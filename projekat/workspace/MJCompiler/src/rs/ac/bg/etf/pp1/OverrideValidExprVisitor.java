package rs.ac.bg.etf.pp1;

import rs.ac.bg.etf.pp1.ast.Designator;
import rs.ac.bg.etf.pp1.ast.DesignatorArrayAfter;
import rs.ac.bg.etf.pp1.ast.DesignatorWithScopeBefore;
import rs.ac.bg.etf.pp1.ast.NoDesignatorArray;
import rs.ac.bg.etf.pp1.ast.NoDesignatorWithScopeBefore;
import rs.etf.pp1.symboltable.Tab;
import rs.etf.pp1.symboltable.concepts.Obj;
import rs.etf.pp1.symboltable.concepts.Struct;

public class OverrideValidExprVisitor extends ValidExprVisitor {
	
	@Override
	public void visit(Designator designator) {
		if (!validity || level > 0) { //koci se ulazak u proveravanje designatora, ako je u pitanju niz, ili ako postoji pocetak ugnjezdavanja, pa treba da poniremo
			return;
		}
		
		if(designator.getDesignatorWithScope() instanceof NoDesignatorWithScopeBefore) { //nema scope
			if(designator.getDesignatorArray() instanceof NoDesignatorArray) { //nema niz
				String designatorName = designator.getName();
				Obj symbol = Tab.find(designatorName);
				if (symbol == Tab.noObj) {
					report_error("Ime "+ designator.getName()+" nije ranije deklarisano, da bi mogli da ga koristimo! ", designator);
					validity = false; //da se signalizira nevalidna situacija, da zaustavi return, da se ne obradjuje ako vec ovo ne valja
				} else {
					exprObj = symbol;
					exprDesignatorName = symbol.getName();
					acceptChange(Tab.find(designatorName).getType());					
				}
				
			} else { //ima niz
				String designatorName = designator.getName();
				Obj symbol = Tab.find(designatorName);
				if (symbol == Tab.noObj) {
					report_error("Ime "+ designator.getName()+" nije ranije deklarisano, da bi mogli da ga koristimo! ", designator);
					validity = false;
				} else {
					
					if (symbol.getType().getKind() != Struct.Array) { //referenca koju pronadjemo bi morala biti niz, znaci samo o imenu govorimo, ne niz[expr]
						report_error("Ime "+ designator.getName()+" nije niz po deklaraciji! ", designator);
						validity = false;
						return;
					}
					Struct noviTip = new Struct(symbol.getType().getElemType().getKind());
					exprObj = new Obj(symbol.getType().getElemType().getKind(), designatorName, noviTip);
					exprDesignatorName = symbol.getName() + "[]";
					
					ValidExprVisitor visitor = new ValidExprVisitor();
			    	visitor.setErrorOccurredObject(error);
			    	((DesignatorArrayAfter)designator.getDesignatorArray()).getExpr().traverseBottomUp(visitor); //obilazak expr, u saglasnosti sa [ iz gramatike
			    	
			    	if (!visitor.validity) { //ako je visitor nakon obilaska vratio fleg da nije validno, onda preskacemo ostatak koda
			    		validity = false;	//propagiranje vrednosti validity
			    		return;				//jedna mogucnost:fakticki dodje provera za niz ali na nivou onoga sto je pozvano, tj. return pa ime niza samo
			    	}
			    	
			    	if(visitor.exprType.getKind() != Tab.intType.getKind()) { //provera za tip argumenta niza, ali pristupljenog elementa niza
						report_error("Argument niza "+ designator.getName() + " nije int tipa! ", designator);
						validity = false;
						return;
					}
			    	
			    	acceptChange(symbol.getType().getElemType(), false); //sada konacno radimo proveru nad tipom elementa izraza, koji je za nas relevantan
				}
			}
			
		} else { //ima scope
			if(designator.getDesignatorArray() instanceof NoDesignatorArray) { //nema niz
				String namespaceName = designator.getName();
				String designatorName = ((DesignatorWithScopeBefore)designator.getDesignatorWithScope()).getName();

				Obj namespaceObj = Tab.find(namespaceName); //zapamceno najvise za posle
				if (namespaceObj == Tab.noObj) {
					report_error("Ime "+ namespaceName +" nije ranije deklarisano, da bi mogli da ga koristimo! ", designator);
					validity = false; //da se signalizira nevalidna situacija, da zaustavi return, da se ne obradjuje ako vec ovo ne valja
					return;
				}
				
				boolean foundDesignator = false; //fleg za pronadjenost
				Obj designatorObj = null;
				Struct designatorStruct = null; //fleg za pronadjeni konkretan, koji zelimo da pronadjemo spremljen
				for(Obj o : namespaceObj.getLocalSymbols()) { //prodjemo putem for kroz sve lokalne simbole naseg namespace
					if (o.getName().equals(designatorName)) { //ako pronadjemo medju njima odgovarajuci, onda to zapisujemo u 2 flega i prekidamo for
						foundDesignator = true;
						designatorObj = o;
						designatorStruct = o.getType();
						break;
					}
				}
				
				if (!foundDesignator) { //ako nije pronadjeno, ime javimo gresku
					report_error("Ime "+ designatorName +" nije ranije deklarisano u namespace-u " + namespaceName + ", da bi mogli da ga koristimo! ", designator);
					validity = false;
				} else {
					exprObj = designatorObj;
					exprDesignatorName = namespaceName + "::" + designatorName;
					acceptChange(designatorStruct, false); //u suprotnom za to ime radimo proveru
				}
				
			} else { //ima niz
				String namespaceName = designator.getName();
				String designatorName = ((DesignatorWithScopeBefore)designator.getDesignatorWithScope()).getName();

				Obj namespaceObj = Tab.find(namespaceName); //zapamceno najvise za posle
				if (namespaceObj == Tab.noObj) {
					report_error("Ime "+ namespaceName +" nije ranije deklarisano, da bi mogli da ga koristimo! ", designator);
					validity = false; //da se signalizira nevalidna situacija, da zaustavi return, da se ne obradjuje ako vec ovo ne valja
					return;
				}
				
				boolean foundDesignator = false; //fleg za pronadjenost
				Obj designatorObj = null;
				Struct designatorStruct = null; //fleg za pronadjeni konkretan, koji zelimo da pronadjemo spremljen
				for(Obj o : namespaceObj.getLocalSymbols()) { //prodjemo putem for kroz sve lokalne simbole naseg namespace
					if (o.getName().equals(designatorName)) { //ako pronadjemo medju njima odgovarajuci, onda to zapisujemo u 2 flega i prekidamo for
						foundDesignator = true;
						designatorObj = o;
						designatorStruct = o.getType();
						break;
					}
				}
				
				if (!foundDesignator) { //ako nije pronadjeno, ime javimo gresku
					report_error("Ime "+ designatorName +" nije ranije deklarisano u namespace-u " + namespaceName + ", da bi mogli da ga koristimo! ", designator);
					validity = false;
				} else {
					
					if (designatorStruct.getKind() != Struct.Array) { //referenca koju pronadjemo bi morala biti niz, znaci samo o imenu govorimo, ne niz[expr]
						report_error("Ime "+ designatorName+" nije niz po deklaraciji! ", designator);
						validity = false;
						return;
					}
					Struct noviTip = new Struct(designatorObj.getType().getElemType().getKind());
					exprObj = new Obj(designatorObj.getType().getElemType().getKind(), designatorName, noviTip);
					exprDesignatorName = namespaceName + "::" + designatorName + "[]";
					
					ValidExprVisitor visitor = new ValidExprVisitor();
			    	visitor.setErrorOccurredObject(error);
			    	((DesignatorArrayAfter)designator.getDesignatorArray()).getExpr().traverseBottomUp(visitor); //obilazak expr, u saglasnosti sa [ iz gramatike
			    	
			    	if (!visitor.validity) { //ako je visitor nakon obilaska vratio fleg da nije validno, onda preskacemo ostatak koda
			    		validity = false;	//propagiranje vrednosti validity
			    		return;				//jedna mogucnost:fakticki dodje provera za niz ali na nivou onoga sto je pozvano, tj. return pa ime niza samo
			    	}
			    	
			    	if(visitor.exprType.getKind() != Tab.intType.getKind()) { //provera za tip argumenta niza, ali pristupljenog elementa niza
						report_error("Argument niza "+ designatorName + " nije int tipa! ", designator);
						validity = false;
						return;
					}
			    		
					acceptChange(designatorStruct.getElemType(), false); //sada konacno radimo proveru nad tipom elementa izraza, koji je za nas relevantan
				}
			}
		}
		termCounter++;
	}

}
