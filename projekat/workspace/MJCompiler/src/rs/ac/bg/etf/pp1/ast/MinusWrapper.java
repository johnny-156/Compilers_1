// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class MinusWrapper implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private Minus Minus;

    public MinusWrapper (Minus Minus) {
        this.Minus=Minus;
        if(Minus!=null) Minus.setParent(this);
    }

    public Minus getMinus() {
        return Minus;
    }

    public void setMinus(Minus Minus) {
        this.Minus=Minus;
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
        if(Minus!=null) Minus.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(Minus!=null) Minus.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(Minus!=null) Minus.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MinusWrapper(\n");

        if(Minus!=null)
            buffer.append(Minus.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MinusWrapper]");
        return buffer.toString();
    }
}
