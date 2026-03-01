// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class GlobalVarType implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private GlobalVarTypeChoose GlobalVarTypeChoose;

    public GlobalVarType (GlobalVarTypeChoose GlobalVarTypeChoose) {
        this.GlobalVarTypeChoose=GlobalVarTypeChoose;
        if(GlobalVarTypeChoose!=null) GlobalVarTypeChoose.setParent(this);
    }

    public GlobalVarTypeChoose getGlobalVarTypeChoose() {
        return GlobalVarTypeChoose;
    }

    public void setGlobalVarTypeChoose(GlobalVarTypeChoose GlobalVarTypeChoose) {
        this.GlobalVarTypeChoose=GlobalVarTypeChoose;
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
        if(GlobalVarTypeChoose!=null) GlobalVarTypeChoose.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVarTypeChoose!=null) GlobalVarTypeChoose.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVarTypeChoose!=null) GlobalVarTypeChoose.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVarType(\n");

        if(GlobalVarTypeChoose!=null)
            buffer.append(GlobalVarTypeChoose.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVarType]");
        return buffer.toString();
    }
}
