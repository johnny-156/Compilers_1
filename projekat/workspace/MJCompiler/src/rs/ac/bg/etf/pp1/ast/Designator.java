// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class Designator implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private String name;
    private DesignatorWithScope DesignatorWithScope;
    private DesignatorArray DesignatorArray;

    public Designator (String name, DesignatorWithScope DesignatorWithScope, DesignatorArray DesignatorArray) {
        this.name=name;
        this.DesignatorWithScope=DesignatorWithScope;
        if(DesignatorWithScope!=null) DesignatorWithScope.setParent(this);
        this.DesignatorArray=DesignatorArray;
        if(DesignatorArray!=null) DesignatorArray.setParent(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public DesignatorWithScope getDesignatorWithScope() {
        return DesignatorWithScope;
    }

    public void setDesignatorWithScope(DesignatorWithScope DesignatorWithScope) {
        this.DesignatorWithScope=DesignatorWithScope;
    }

    public DesignatorArray getDesignatorArray() {
        return DesignatorArray;
    }

    public void setDesignatorArray(DesignatorArray DesignatorArray) {
        this.DesignatorArray=DesignatorArray;
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
        if(DesignatorWithScope!=null) DesignatorWithScope.accept(visitor);
        if(DesignatorArray!=null) DesignatorArray.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(DesignatorWithScope!=null) DesignatorWithScope.traverseTopDown(visitor);
        if(DesignatorArray!=null) DesignatorArray.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(DesignatorWithScope!=null) DesignatorWithScope.traverseBottomUp(visitor);
        if(DesignatorArray!=null) DesignatorArray.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Designator(\n");

        buffer.append(" "+tab+name);
        buffer.append("\n");

        if(DesignatorWithScope!=null)
            buffer.append(DesignatorWithScope.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(DesignatorArray!=null)
            buffer.append(DesignatorArray.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Designator]");
        return buffer.toString();
    }
}
