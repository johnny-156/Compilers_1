// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class GlobalVarOption implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String varName;
    private GlobalVarArray GlobalVarArray;

    public GlobalVarOption (String varName, GlobalVarArray GlobalVarArray) {
        this.varName=varName;
        this.GlobalVarArray=GlobalVarArray;
        if(GlobalVarArray!=null) GlobalVarArray.setParent(this);
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public GlobalVarArray getGlobalVarArray() {
        return GlobalVarArray;
    }

    public void setGlobalVarArray(GlobalVarArray GlobalVarArray) {
        this.GlobalVarArray=GlobalVarArray;
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
        if(GlobalVarArray!=null) GlobalVarArray.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVarArray!=null) GlobalVarArray.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVarArray!=null) GlobalVarArray.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVarOption(\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        if(GlobalVarArray!=null)
            buffer.append(GlobalVarArray.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVarOption]");
        return buffer.toString();
    }
}
