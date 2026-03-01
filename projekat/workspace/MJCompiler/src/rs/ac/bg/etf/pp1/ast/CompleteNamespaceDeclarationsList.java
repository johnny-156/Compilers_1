// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class CompleteNamespaceDeclarationsList extends NamespaceDeclarations {

    private MultipleDeclarationsList MultipleDeclarationsList;

    public CompleteNamespaceDeclarationsList (MultipleDeclarationsList MultipleDeclarationsList) {
        this.MultipleDeclarationsList=MultipleDeclarationsList;
        if(MultipleDeclarationsList!=null) MultipleDeclarationsList.setParent(this);
    }

    public MultipleDeclarationsList getMultipleDeclarationsList() {
        return MultipleDeclarationsList;
    }

    public void setMultipleDeclarationsList(MultipleDeclarationsList MultipleDeclarationsList) {
        this.MultipleDeclarationsList=MultipleDeclarationsList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(MultipleDeclarationsList!=null) MultipleDeclarationsList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MultipleDeclarationsList!=null) MultipleDeclarationsList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MultipleDeclarationsList!=null) MultipleDeclarationsList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CompleteNamespaceDeclarationsList(\n");

        if(MultipleDeclarationsList!=null)
            buffer.append(MultipleDeclarationsList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CompleteNamespaceDeclarationsList]");
        return buffer.toString();
    }
}
