// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclOption implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String constName;
    private ConstValues ConstValues;

    public ConstDeclOption (String constName, ConstValues ConstValues) {
        this.constName=constName;
        this.ConstValues=ConstValues;
        if(ConstValues!=null) ConstValues.setParent(this);
    }

    public String getConstName() {
        return constName;
    }

    public void setConstName(String constName) {
        this.constName=constName;
    }

    public ConstValues getConstValues() {
        return ConstValues;
    }

    public void setConstValues(ConstValues ConstValues) {
        this.ConstValues=ConstValues;
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
        if(ConstValues!=null) ConstValues.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstValues!=null) ConstValues.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstValues!=null) ConstValues.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclOption(\n");

        buffer.append(" "+tab+constName);
        buffer.append("\n");

        if(ConstValues!=null)
            buffer.append(ConstValues.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclOption]");
        return buffer.toString();
    }
}
