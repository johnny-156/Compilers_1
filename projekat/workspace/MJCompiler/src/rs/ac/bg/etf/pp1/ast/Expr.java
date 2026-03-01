// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class Expr implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private MinusWrapper MinusWrapper;
    private ExprWhole ExprWhole;

    public Expr (MinusWrapper MinusWrapper, ExprWhole ExprWhole) {
        this.MinusWrapper=MinusWrapper;
        if(MinusWrapper!=null) MinusWrapper.setParent(this);
        this.ExprWhole=ExprWhole;
        if(ExprWhole!=null) ExprWhole.setParent(this);
    }

    public MinusWrapper getMinusWrapper() {
        return MinusWrapper;
    }

    public void setMinusWrapper(MinusWrapper MinusWrapper) {
        this.MinusWrapper=MinusWrapper;
    }

    public ExprWhole getExprWhole() {
        return ExprWhole;
    }

    public void setExprWhole(ExprWhole ExprWhole) {
        this.ExprWhole=ExprWhole;
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
        if(MinusWrapper!=null) MinusWrapper.accept(visitor);
        if(ExprWhole!=null) ExprWhole.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(MinusWrapper!=null) MinusWrapper.traverseTopDown(visitor);
        if(ExprWhole!=null) ExprWhole.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(MinusWrapper!=null) MinusWrapper.traverseBottomUp(visitor);
        if(ExprWhole!=null) ExprWhole.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Expr(\n");

        if(MinusWrapper!=null)
            buffer.append(MinusWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprWhole!=null)
            buffer.append(ExprWhole.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Expr]");
        return buffer.toString();
    }
}
