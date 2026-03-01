package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.CompleteGlobalDeclarationsList;
import rs.etf.pp1.mj.runtime.Code;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.*;
import rs.etf.pp1.symboltable.visitors.DumpSymbolTableVisitor;

public class Helper {
	
	public static Obj getObj(String objName) { //koristimo je i za dohvatanje metode i designatora	
		return getObjByNamespace(objName, CodeGenerator.namespaceObj); //da ne bi radili prosledjivanje, mi uzmemo i zalepimo ovde da je to polje od CodeGenerator
	}
	
	public static Obj getObjByNamespace(String objName, Obj namespaceObj) {
		Obj obj = null;	
		
		if (namespaceObj != null) { //ako je nesto sto trazimo unutar namespace
			
			for ( Obj o : namespaceObj.getLocalSymbols() ) { //iteriramo kroz lokalne simbole u namespace
				if (o.getName().equals(objName)) {
					obj = o;
				}
			}			
			
			if(obj == null) { //ako object nije pronadjen, onda trazimo medju lokalnim simbolima
				obj = findInTheWidestScope(objName); //pretrazivanje u sirem opsegu, moze otici iznad opsega programa, npr za eol
			}
			
		} else { //onda to nesto sto trazimo nije u namespace, vec u globalnom scope
			
			if (CodeGenerator.methodObj == null) { //ako metoda u tom trenutku ne postoji, trazimo je globalno, trazimo i promenljivu globalno
				obj = Tab.find(objName);
				
			} else { //ako metoda postoji. promenljiva je lokalna u njoj, nadalje pretraga za lokalnu promenljivu
				
				obj = findInTheWidestScope(objName); //pretrazivanje u sirem opsegu, moze otici iznad opsega programa, npr za eol
				
				if (obj == Tab.noObj) { //ako object nije pronadjen na najsirem scope, onda cemo ga traziti na nivou lokalnih promenljivih u metodi
					for (Obj o : CodeGenerator.methodObj.getLocalSymbols()) { // pretraga simbola unutar scopa metode
						if (o.getName().equals(objName)) {
							obj = o;
						}
					}
				}
			}
			
		}
		return obj;
	}
	
	//pomocna metoda za pretragu iznad scope od programa, za eol npr
	private static Obj findInTheWidestScope(String objName) {
		Scope widestScope = SemanticAnalyzer.programScope; 				//najsiri scope
		
		Scope currentScope = Tab.currentScope;							//pamtimo trenutni da bi posle vratili na staro
		Tab.currentScope = widestScope;									//uzimamo u trenutni scope onaj najsiri
		
		Obj symbol = Tab.find(objName);									//pretraga na tom nivou i iznad, ali iznad ne postoji
		
		Tab.currentScope = currentScope;								//vracanje scope na staru vrednost
		return symbol;													//pronadjeni se vraca
	}
/*----------------------------------------------------------------------------------------------------------------------------------------------------------*/
	public static void addInstructionsForPrintingString(String toPrint, int size) { //deo koda za ispisivanje true i false slovo po slovo
		for (int i = 0; i<toPrint.length(); i++) {
			Code.loadConst(toPrint.codePointAt(i));
			Code.loadConst(size);
			Code.put(Code.bprint);
		}
	}
}

/**
 * 
		
uputstvo: resim semantiku(ili preko if, ili zakomentarisem)
			obezbedim da mi designator u prvoj opciji vrati adresu matrice, da bih ja koriscenjem arrayLength dohvatio obe dimenzije
			uvedem jos 3 promenljive i sacuvamo broj vrsti, broj koloni, brojac za prvo i brojac za drugo
			
			int[] mat = new int[2][3];
			int[] mat2=new int[3][2];
			mat2[][];
			mat1 = transpose(mat);
			
			
			kod
			...
	(1)		labela:			trenutniPc ove labele ide u listu (vrednost 1), lista sa koriscenjem labele je prazna
			...
			...
			
	(2)		goto labela2	NE ZNAMO KOJI JE PC, lista sa koriscenjem = [pc vrednost 2]
			jmp PC VREDNOST 4
			...
			...
	(3)		goto labela		pc=vrednost 1, lista sa koriscenjem = [pc vrednost 3]
			...
			...
			
			
			
	(4)		labela2:		pc=vrednost 4, lista sa koriscenjem = [pc vrednost 2]		
			
			...
	(5)		goto labela		pc=vrednost 3, lista sa koriscenjem = [pc vrednost 3, pc vrednost 5]
	
	
	KRAJNJI REZULTAT JE HASH MAPA:
	labela: pc=vrednost 1, lista sa koriscenjem = [pc vrednost 3, pc vrednost 5]
	labela2: pc=vrednost 4, lista sa koriscenjem = [pc vrednost 2]	
	
	fixup(ides u Code i prepises argumente iz put2(), tj adr-pc+1)
	
	================================================================================
	// dodata pomocna promenljiva za manipulaciju sa matricama, u SemanticAnalyzer, na kraj visitor visit(CompleteGlobalDeclarationsList globalDecls)
    	Tab.insert(Obj.Var, "_", new Struct(Struct.Int)); //brVrsti 
    	nVars++;
    	
    	Tab.insert(Obj.Var, "-", new Struct(Struct.Int)); //brKoloni
    	nVars++;
    	
    	Tab.insert(Obj.Var, "?", new Struct(Struct.Int)); //brojac1
    	nVars++;
    	
    	Tab.insert(Obj.Var, "#", new Struct(Struct.Int)); //brojac2
    	nVars++;
			
		public class DumpSymbolTableCustomVisitor extends DumpSymbolTableVisitor {
	
	//dodati sa pocetka kako se koriscene promenljive ne bi ispisivale u tabeli simbola
	@Override
	public void visitObjNode(Obj objToVisit) {
		if(objToVisit.getName().equals("_") || objToVisit.getName().equals("-") ||
				objToVisit.getName().equals("?") || objToVisit.getName().equals("#")) { //u slucaju da dodajemo promenljive, a da ne zelimo da se to vidi u tabeli simbola
			return;
		}
		
		PRIMER ZA IF
	/**
		 * 		if(brojRedova + brojKolona > 5){
		 *      	print(1);
		 *      } else {
		 *      	print(0);
		 *      }
		 *      
		 *      uzmemo redove i sacuvamo, uzmemo kolone i sacuvamo
		 *      povucemo jedne, pa povucemo druge
		 *      saberemo
		 *      
		 *      jle zbir > 5 falseBlok
		 *      
		 *      trueBlok:
		 *      ucitam 1
		 *      print
		 *      jmp nastavak
		 *      
		 *      falseBlok:
		 *      ucitam 0
		 *      print
		 *      jmp nastavak
		 *      
		 *      
		 *      nastavak:
		 
				//dup da bi mi ostalo posle za pristup
				Code.put(Code.dup);			//adrNizaVrsti adrNizaVrsti
				
				//na steku se nalazi vrednost mat, a to je referenca na adresu niza vrsti
				Code.put(Code.arraylength);	//adrNizaVrsti adrNizaVrsti => length1
				
				//pamcenje 1
				Obj tempI = Tab.find("_");	// adrNizaVrsti length1
				Code.put(Code.putstatic);	// adrNizaVrsti length1
				Code.put2(tempI.getAdr());	// adrNizaVrsti (tempI = length1)	
			
				//pristup prvom nizu kolona samo da dohvatimo opstu duzinu svih
				Code.loadConst(0);			// adrNizaVrsti 0
				Code.put(Code.aload);		// adrNizaKolona(prvog)
				
				//izvlacimo mu duzinu
				Code.put(Code.arraylength); // length2
				
				//pamcenje 2
				Obj tempJ = Tab.find("-");	// length2
				Code.put(Code.putstatic);	// length2
				Code.put2(tempJ.getAdr());	// (tempJ = length2)
				
				//dohvatanje jednog i drugog
				Code.put(Code.getstatic);		
				Code.put2(tempI.getAdr());		// brojVrsti
				
				Code.put(Code.getstatic);		
				Code.put2(tempJ.getAdr());		// brojVrsti brojKolona
				
				//Sabiranje i priprema za uslov
				Code.put(Code.add);				// zbir
				Code.loadConst(5);				// zbir 5
				
				//poredjenje
				Code.put(Code.jcc + Code.le);	// empty
				int fixupFalseBlok = Code.pc;
				Code.put2(0);
				
				//labela za trueBlok u koju se ponire
				Code.loadConst(1);				// 1
				Code.put(Code.print);			// empty
				Code.put(Code.jmp);
				int fixupNastavak = Code.pc;
				Code.put2(0);
				
				//labela za falseBlok
				Code.fixup(fixupFalseBlok);
				Code.loadConst(0);				// 0
				Code.loadConst(0);
				Code.put(Code.print);			// empty
				
				//labela za nastavak
				Code.fixup(fixupNastavak);
	
		PRIMER ZA FOR U FOR
		
		for(int i = 0; i < brVrste; i++){
			for(int j = 0; i < brKolone; j++){
				print(mat[i][j]); 
				print(' ');
			}
			print(eol);
		}
		
		//u startu na steku imamo adresu mat
		
		//dup da bi mi ostalo posle za pristup
		Code.put(Code.dup);			//adrNizaVrsti adrNizaVrsti
		Code.put(Code.dup);			//adrNizaVrsti adrNizaVrsti adrNizaVrsti
		
		//na steku se nalazi vrednost mat, a to je referenca na adresu niza vrsti
		Code.put(Code.arraylength);	//adrNizaVrsti adrNizaVrsti adrNizaVrsti => length1
		
		//pamcenje 1
		Obj tempI = Tab.find("_");	// adrNizaVrsti adrNizaVrsti length1
		Code.put(Code.putstatic);	// adrNizaVrsti adrNizaVrsti length1
		Code.put2(tempI.getAdr());	// adrNizaVrsti adrNizaVrsti (tempI = length1)	
	
		//pristup prvom nizu kolona samo da dohvatimo opstu duzinu svih
		Code.loadConst(0);			// adrNizaVrsti adrNizaVrsti 0
		Code.put(Code.aload);		// adrNizaVrsti adrNizaKolona(prvog)
		
		//izvlacimo mu duzinu
		Code.put(Code.arraylength); // adrNizaVrsti length2
		
		//pamcenje 2
		Obj tempJ = Tab.find("-");	// adrNizaVrsti length2
		Code.put(Code.putstatic);	// adrNizaVrsti length2
		Code.put2(tempJ.getAdr());	// adrNizaVrsti (tempJ = length2)
		
		//-----------------------------------------------------------
		Obj tempK = Tab.find("?");
		Code.loadConst(0);			// adrNizaVrsti 0
		Code.put(Code.putstatic);
		Code.put2(tempK.getAdr());	// adrNizaVrsti tempK = 0	
		
		int proveraUslova1 = Code.pc;
		//Code.fixup(fixupKrajUnutra);
		
		Code.put(Code.getstatic);		
		Code.put2(tempI.getAdr());		// adrNizaVrsti brojVrsti(2)
		
		// oduzimamo 1 od broja vrsti da bi mogli da poredimo sa indeksom i
		Code.loadConst(1);			// adrNizaVrsti 2 1
		Code.put(Code.sub);			// adrNizaVrsti 1
		
		Code.put(Code.getstatic);		
		Code.put2(tempK.getAdr());		// adrNizaVrsti 1 tempK						
		Code.put(Code.jcc + Code.lt);	// adrNizaVrsti
		int fixupKraj = Code.pc;
		Code.put2(0);
			
			Obj tempL = Tab.find("#");
			Code.loadConst(0);			// adrNizaVrsti 0
			Code.put(Code.putstatic);
			Code.put2(tempL.getAdr());	// adrNizaVrsti tempK = 0
		
			//ovde pocinje unutrasnji for
			int proveraUslova2 = Code.pc;
			
			Code.put(Code.getstatic);		
			Code.put2(tempJ.getAdr());		// adrNizaVrsti BrKolona(3)
			
			// oduzimamo 1 od broja vrsti da bi mogli da poredimo sa indeksom i
			Code.loadConst(1);			// adrNizaVrsti 3 1
			Code.put(Code.sub);			// adrNizaVrsti 2
			
			Code.put(Code.getstatic);		
			Code.put2(tempL.getAdr());		// adrNizaVrsti 2 tempL						
			Code.put(Code.jcc + Code.lt);	// adrNizaVrsti
			int fixupIzlazIzUnutra = Code.pc;
			Code.put2(0);
			//------------------------------------------------------------------
				Code.put(Code.dup);			// adrNizaVrsti adrNizaVrsti, da nam ne zafali kasnije za sledecu iteraciju
			
				Code.put(Code.getstatic);		
				Code.put2(tempK.getAdr());		// adrNizaVrsti adrNizaVrsti brojacVrsta
				
				Code.put(Code.aload);			// adrNizaVrsti adrNizaKolona(odgovarajuceg)
				
				Code.put(Code.getstatic);		
				Code.put2(tempL.getAdr());		// adrNizaVrsti adrNizaKolona(odgovarajuceg) brojacKolone
				
				Code.put(Code.aload);			//adrNizaVrsti vredost polja[brojacV][brojacK]
				Code.loadConst(2);
				Code.put(Code.print);
			//------------------------------------------------------------------
			//inkrementiranje brojaca tempL
			Code.put(Code.getstatic);		
			Code.put2(tempL.getAdr());		// tempL
			Code.loadConst(1);				// tempL 1
			Code.put(Code.add);				// tempL+1
			Code.put(Code.putstatic);
			Code.put2(tempL.getAdr());		// empty 
		
			Code.putJump(proveraUslova2);
		
		//nastavljam spoljasnji for nakon ugnjezdenog
		Code.fixup(fixupIzlazIzUnutra);
			
		//inkrementiranje brojaca tempK
		Code.put(Code.getstatic);		
		Code.put2(tempK.getAdr());		// tempK
		Code.loadConst(1);				// tempK 1
		Code.put(Code.add);				// tempK+1
		Code.put(Code.putstatic);
		Code.put2(tempK.getAdr());		// empty 
		
		Code.putJump(proveraUslova1);					
		
		Code.fixup(fixupKraj);
				
		//********************************************************************************************************************
	
 		*/
