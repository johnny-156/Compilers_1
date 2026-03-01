// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class MultipleDeclarationsListSingleDeclaration extends MultipleDeclarationsList {

    private SingleDeclaration SingleDeclaration;

    public MultipleDeclarationsListSingleDeclaration (SingleDeclaration SingleDeclaration) {
        this.SingleDeclaration=SingleDeclaration;
        if(SingleDeclaration!=null) SingleDeclaration.setParent(this);
    }

    public SingleDeclaration getSingleDeclaration() {
        return SingleDeclaration;
    }

    public void setSingleDeclaration(SingleDeclaration SingleDeclaration) {
        this.SingleDeclaration=SingleDeclaration;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(SingleDeclaration!=null) SingleDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(SingleDeclaration!=null) SingleDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(SingleDeclaration!=null) SingleDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MultipleDeclarationsListSingleDeclaration(\n");

        if(SingleDeclaration!=null)
            buffer.append(SingleDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MultipleDeclarationsListSingleDeclaration]");
        return buffer.toString();
    }
}
