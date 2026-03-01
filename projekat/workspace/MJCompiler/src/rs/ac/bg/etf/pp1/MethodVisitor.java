package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.*;
import rs.etf.pp1.symboltable.*;
import rs.etf.pp1.symboltable.concepts.*;

public class MethodVisitor extends MyVisitor {
	
	public String typeName;
	public Obj retType;
	public String methodName;
	
	public boolean mainDoesntExist = true;
	public boolean mainWrongType = false;
	public boolean mainWrongParam = false;
	public boolean mainWrongReturn = false;
	public boolean isInsideNamespace;
	public boolean methodExists = false;
	
	public int numberOfFormParam; //ovde se pobroje formalni parametri za svaku metodu
	public int numberOfLocalParams; //ovde se pobroje lokalni parametri metode, pa oba ucestvuju u enter instrukciji
	
	public Obj methodObj;
	public static Scope methodScope;	//napravljeno da bude dostupan scope za pristup
	
	public boolean returnFound;
	public Struct returnType;
	
	public MethodVisitor() {
		
	}
	
	public MethodVisitor(boolean isInsideNamespace) {
		this.isInsideNamespace = isInsideNamespace;
	}
	
	public void visit(RetTypeWrapper retTypeWrapper) {
		if (retTypeWrapper.getRetType() instanceof RetTypeInt) {
			this.typeName = "int";
		} else if(retTypeWrapper.getRetType() instanceof RetTypeChar) {
			this.typeName = "char";
		} else if(retTypeWrapper.getRetType() instanceof RetTypeBool) {
			this.typeName = "bool";
		} else if(retTypeWrapper.getRetType() instanceof RetTypeVoid) {
			this.typeName = "void";
		}
		Obj typeNode = Tab.find(typeName);
		this.retType = typeNode;
	}
	
    public void visit(MethName methName) {
    	methodExists = false;
    	this.methodName = methName.getName();
    	if(Tab.find(methodName) == Tab.noObj) {
    		this.methodObj = Tab.insert(Obj.Meth, methName.getName(), this.retType.getType());    		
		}else {
			this.report_error("Metoda imenovana kao: " + this.methodName + " vec postoji!", methName);
			methodExists = true;
			return; 	//ako metoda postoji, onda necemo da otvaramo scope bez potrebe
		}
    	
    	Tab.openScope();
    	methodScope = Tab.currentScope; //zapamcen scope u tom trenutku
    }

    public void visit(MethodDecl methodDecl) {
    	if(!this.isInsideNamespace) {
    		if(this.methodName.equals("main") && !this.isInsideNamespace) {	//bezveze duplirano, ali necu menjati
        		this.mainDoesntExist = false;
        		if(!this.typeName.equals("void")) {
        			this.mainWrongType = true;
        		}
        		if(!(methodDecl.getFormPars() instanceof NoSingleFormParamList)) {
        			this.mainWrongParam = true;
        		}
        		if(this.returnFound) {
        			this.mainWrongReturn = true;
        		}
        	}
    	}
    	
    	if(!this.returnFound /*&& this.methodObj.getType() != Tab.noType*/&& !this.typeName.equals("void")) {
			if (this.methodName.equals("main") && !this.isInsideNamespace) {	//dopuna da za duplirani main ne ulazi u ponovnu proveru
				this.mainWrongType = true;
			} else {
				report_error("Funkcija " + methodObj.getName() + " nema return iskaz!", methodDecl);
			}
		}
    	
    	if (!methodExists) {	//ako metoda postoji, nismo otvarali scope, samim tim ne treba ni da ga zatvaramo
    		//Tab.chainLocalSymbols(methodObj);
        	Tab.closeScope();  
        	methodObj.setLevel(numberOfFormParam); //postavljena oba parametra, kako bi mogli da radimo enter kasnije 
        	methodObj.setFpPos(numberOfLocalParams);        	
    	}   	
    	
    	this.returnFound = false;
    	this.methodObj = null;
    }
    
    public void visit(MethLBRACE methLB) {
    	if (!methodExists) {
    		Tab.chainLocalSymbols(methodObj); 		
    	} 
    }
    
    public void visit(SingleFormParamList formPars) {
    	DeclarationsVisitor visitor = new DeclarationsVisitor();
		visitor.setErrorOccurredObject(error);
		formPars.traverseBottomUp(visitor);
		
		this.numberOfFormParam = visitor.numberOfFormParam; //prosledjivanje broja parametara
    }
    
    public void visit(SingleVarDeclRoot varDecls) { //ovde ce mi nekako proslediti da zapamtim gore
    	DeclarationsVisitor visitor = new DeclarationsVisitor();
		visitor.setErrorOccurredObject(error);
		varDecls.traverseBottomUp(visitor);
		numberOfLocalParams++;
    }
    
    public void visit(StatementListWrapper statementDecls) {
    	StatementVisitor visitor = new StatementVisitor();
		visitor.setErrorOccurredObject(error);
		statementDecls.traverseBottomUp(visitor);
    }
   
	public void visit(StatementReturnExpr returnExpr){
    	this.returnFound = true;
    	// Poziv posebnog Expr visitora ciji zadatak jeste da vrati kog je tipa rezultat izraza i da vrati da li je izraz dobro formulisan
    	ValidExprVisitor visitor = new ValidExprVisitor();
    	visitor.setErrorOccurredObject(error);
    	returnExpr.getExpr().traverseBottomUp(visitor);
    	// dodato zbog pogresne linije u kojoj se ispise greska
    	ExprWhole expr = returnExpr.getExpr().getExprWhole();					//promenio ovde
    	
    	this.returnType = visitor.exprType; //izvuceno iz visitora, tj. dobijeno iz ValidExpr
    	boolean validity = visitor.validity;
    	
    	if (!validity) { //ako nije validno, onda nemoj dalje da proveravas dzabe
    		return;
    	}
    	int retTypeValue = this.retType.getType().getKind(); //ovaj Obj tipa bio
    	int returnTypeValue = this.returnType.getKind(); //ovaj Struct tipa bio
    	if(this.retType == Tab.noObj) { //ako jeste void, onda greska
    		report_error("Return sa argumentom je nepotreban, jer je povratni tip void!", expr);
    	} else {
    		if (
				retTypeValue == Struct.Bool && returnTypeValue != Struct.Bool
				||
				retTypeValue != Struct.Bool && returnTypeValue == Struct.Bool) {
    			
    			report_error("Povratni tip i ono sto vraca return se ne poklapaju!", expr); //ovde pokrivam bool deo, jer nam za taj tip sve komplikuje
    			
    			// ako ni povratna vrednost metode ni povratna vrednost iz return Expr nisu Bool
    		} else if (retTypeValue != Struct.Bool && returnTypeValue != Struct.Bool) {
    			if ( !this.retType.getType().compatibleWith(this.returnType) ) {
    				report_error("Povratni tip i ono sto vraca return se ne poklapaju!", expr);
    	    	}
    		}
    	}
    	
    }
    
    public void visit(StatementReturnEmpty returnEmpty) {
    	this.returnFound = true;
    	this.returnType = Tab.noObj.getType();
    	
    	//ako nije void, onda je greska
    	if(this.retType != Tab.noObj) {
    		report_error("Linija " + returnEmpty.getLine() + ": Return bez argumenta je nepotreban, jer povratni tip nije void!", null);
    	}
    }
}