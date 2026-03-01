// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class CompleteMultipleDeclarationsList extends MultipleDeclarationsList {

    private MultipleDeclarationsList MultipleDeclarationsList;
    private SingleDeclaration SingleDeclaration;

    public CompleteMultipleDeclarationsList (MultipleDeclarationsList MultipleDeclarationsList, SingleDeclaration SingleDeclaration) {
        this.MultipleDeclarationsList=MultipleDeclarationsList;
        if(MultipleDeclarationsList!=null) MultipleDeclarationsList.setParent(this);
        this.SingleDeclaration=SingleDeclaration;
        if(SingleDeclaration!=null) SingleDeclaration.setParent(this);
    }

    public MultipleDeclarationsList getMultipleDeclarationsList() {
        return MultipleDeclarationsList;
    }

    public void setMultipleDeclarationsList(MultipleDeclarationsList MultipleDeclarationsList) {
        this.MultipleDeclarationsList=MultipleDeclarationsList;
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
        if(MultipleDeclarationsList!=null) MultipleDeclarationsList.accept(visitor);
        if(SingleDeclaration!=null) SingleDeclaration.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MultipleDeclarationsList!=null) MultipleDeclarationsList.traverseTopDown(visitor);
        if(SingleDeclaration!=null) SingleDeclaration.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MultipleDeclarationsList!=null) MultipleDeclarationsList.traverseBottomUp(visitor);
        if(SingleDeclaration!=null) SingleDeclaration.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CompleteMultipleDeclarationsList(\n");

        if(MultipleDeclarationsList!=null)
            buffer.append(MultipleDeclarationsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SingleDeclaration!=null)
            buffer.append(SingleDeclaration.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CompleteMultipleDeclarationsList]");
        return buffer.toString();
    }
}
