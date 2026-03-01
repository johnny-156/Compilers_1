// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class NameOfNamespace implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String nameOfName;

    public NameOfNamespace (String nameOfName) {
        this.nameOfName=nameOfName;
    }

    public String getNameOfName() {
        return nameOfName;
    }

    public void setNameOfName(String nameOfName) {
        this.nameOfName=nameOfName;
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
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NameOfNamespace(\n");

        buffer.append(" "+tab+nameOfName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NameOfNamespace]");
        return buffer.toString();
    }
}
