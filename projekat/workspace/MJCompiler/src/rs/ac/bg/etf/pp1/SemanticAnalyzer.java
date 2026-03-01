package rs.ac.bg.etf.pp1;

import java.util.concurrent.atomic.AtomicBoolean;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class SemanticAnalyzer extends MyVisitor {
	
	public Obj programObj;
	public static Scope programScope;	//napravljeno da bude dostupan scope za pristup
	public String progName;
	public boolean isInsideNamespace = false;
	public int nVars;	
	
	public boolean mainDoesntExist = true;
	public boolean mainWrongType = false;
	public boolean mainWrongParam = false;
	public boolean mainWrongReturn = false;
	
	public SemanticAnalyzer(AtomicBoolean error) {
		super(error);
	}
	
	//semantika: SemanticAnalyzer, DeclarationsV, MethodV, StatementV, NamespaceV, ValidExprV, OverrideValidExprV, StatementFuncCallV
	
	//izmena lex i gramatike : build na compile, izmena semantike: build na compile, pa Compiler na run
	
	//koriscenje levela: parser ce svakako da isponire na najdublje smene i posle toga ce se vracati nagore i time ispostovati prioritet operacija, medjutim
	//na steku(redosled) je vazno prolaziti redom, kako bi adresa uvek dolazila pre nego expr po redu
/*----------------------------------------------------------------------------------------------------------------------------------------------------------*/  
    public void visit(ProgName progName){
    	this.progName = progName.getProgName();
    	programObj = Tab.insert(Obj.Prog, this.progName, Tab.noType);
    	Tab.openScope();
    	programScope = Tab.currentScope;
    }
    
    public void visit(Program program){
    	//nVars = Tab.currentScope.getnVars();
    	Tab.chainLocalSymbols(programObj);
    	
    	if(this.mainDoesntExist) {
    		report_error("Main metod ne postoji!", null);
    	} else {
    		if(this.mainWrongType){
    			report_error("Main metod je pogresnog izlaznog tipa, treba da bude void!", null);
    		}
    		if(this.mainWrongParam){
    			report_error("Main metod ima parametre, a treba da bude metoda bez parametara!", null);
    		}
    		if(this.mainWrongReturn){
    			report_error("Main metod ne sme da ima return iskaz, jer je void!", null);
    		}
    	}
    	
    	Tab.closeScope();
    }    
/*----------------------------------------------------------------------------------------------------------------------------------------------------------*/   
    public void visit(CompleteGlobalDeclarationsList globalDecls) {  
    	
    	// Prvi indeks globalnih promenljivih je:
    	int firstIndex = 0;
    	if (NamespaceVisitor.previousNamespace != null) { //ako postoji prethodni namespace
    		firstIndex = NamespaceVisitor.previousNamespace.getLevel() + NamespaceVisitor.variables; //na adresu prve promenljive u namespace, dodamo 
    	}
    	log.info("Prvi indeks globalnih promenljivih je : " + firstIndex);
    	
    	DeclarationsVisitor visitor = new DeclarationsVisitor(0);
    	visitor.setErrorOccurredObject(error); //objekat greske ce biti vidljiv svima, propagiranje: Compiler -> SemanticAnalyzer -> MyVisitor -> DeclarationsVisitor
    	visitor.firstVarIndex = firstIndex; //postavljanje polja iz DeclarationsVisitor
    	globalDecls.traverseBottomUp(visitor);  
    	
    	nVars = visitor.firstVarIndex; //dodelio u nVars
    	
    	// dodata pomocna promenljiva za manipulaciju sa matricama
    	Tab.insert(Obj.Var, "_", new Struct(Struct.Int));
    	nVars++;
    	
    }
/*----------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public void visit(MethodDeclListWrapper methodDecls) {
    	//ni ne pocinjati ako namespace smena ne bude kompletirana iz bilo kog razloga, tada se metoda ne stigne prevezati u pravi scope, vec ode u globalni
    	if (isInsideNamespace) { 
    		return;
    	}
    	MethodVisitor visitor = new MethodVisitor(isInsideNamespace);
    	visitor.setErrorOccurredObject(error);
    	methodDecls.traverseBottomUp(visitor);
    	//prosledjivanje flegova vezanih za proveravanje main metode, ali globalne samo
    	this.mainDoesntExist = visitor.mainDoesntExist;
    	this.mainWrongType = visitor.mainWrongType;
    	this.mainWrongParam = visitor.mainWrongParam;
    	this.mainWrongReturn = visitor.mainWrongReturn;
    }
/*----------------------------------------------------------------------------------------------------------------------------------------------------------*/    
    public void visit(NameOfNamespace non) {		
		isInsideNamespace = true; //sluzio da se regulise potencijalna greska, jer se MethodDeclListWrapper obilazi kao da je globalna
	}
    //ovde imamo dinamicko postavljenje flega za podatak da li smo unutar namespace
    public void visit(SingleNamespace namespaceDecls) {
    	NamespaceVisitor visitor = new NamespaceVisitor();
    	visitor.setErrorOccurredObject(error);
    	namespaceDecls.traverseBottomUp(visitor);
    	isInsideNamespace = false;
    }
}