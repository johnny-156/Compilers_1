// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class Type implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String typeName;
    private TypeWithScope TypeWithScope;

    public Type (String typeName, TypeWithScope TypeWithScope) {
        this.typeName=typeName;
        this.TypeWithScope=TypeWithScope;
        if(TypeWithScope!=null) TypeWithScope.setParent(this);
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName=typeName;
    }

    public TypeWithScope getTypeWithScope() {
        return TypeWithScope;
    }

    public void setTypeWithScope(TypeWithScope TypeWithScope) {
        this.TypeWithScope=TypeWithScope;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(TypeWithScope!=null) TypeWithScope.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(TypeWithScope!=null) TypeWithScope.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(TypeWithScope!=null) TypeWithScope.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Type(\n");

        buffer.append(" "+tab+typeName);
        buffer.append("\n");

        if(TypeWithScope!=null)
            buffer.append(TypeWithScope.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Type]");
        return buffer.toString();
    }
}
