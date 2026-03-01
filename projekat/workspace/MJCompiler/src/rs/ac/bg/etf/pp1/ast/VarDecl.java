// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class VarDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String varDeclName;
    private VarDeclArray VarDeclArray;

    public VarDecl (String varDeclName, VarDeclArray VarDeclArray) {
        this.varDeclName=varDeclName;
        this.VarDeclArray=VarDeclArray;
        if(VarDeclArray!=null) VarDeclArray.setParent(this);
    }

    public String getVarDeclName() {
        return varDeclName;
    }

    public void setVarDeclName(String varDeclName) {
        this.varDeclName=varDeclName;
    }

    public VarDeclArray getVarDeclArray() {
        return VarDeclArray;
    }

    public void setVarDeclArray(VarDeclArray VarDeclArray) {
        this.VarDeclArray=VarDeclArray;
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
        if(VarDeclArray!=null) VarDeclArray.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclArray!=null) VarDeclArray.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclArray!=null) VarDeclArray.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("VarDecl(\n");

        buffer.append(" "+tab+varDeclName);
        buffer.append("\n");

        if(VarDeclArray!=null)
            buffer.append(VarDeclArray.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [VarDecl]");
        return buffer.toString();
    }
}
