// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class WithTwoDimensionsCreate extends TwoDimensionCreate {

    private BeforeMatrixFactor BeforeMatrixFactor;
    private Expr Expr;

    public WithTwoDimensionsCreate (BeforeMatrixFactor BeforeMatrixFactor, Expr Expr) {
        this.BeforeMatrixFactor=BeforeMatrixFactor;
        if(BeforeMatrixFactor!=null) BeforeMatrixFactor.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public BeforeMatrixFactor getBeforeMatrixFactor() {
        return BeforeMatrixFactor;
    }

    public void setBeforeMatrixFactor(BeforeMatrixFactor BeforeMatrixFactor) {
        this.BeforeMatrixFactor=BeforeMatrixFactor;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(BeforeMatrixFactor!=null) BeforeMatrixFactor.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BeforeMatrixFactor!=null) BeforeMatrixFactor.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BeforeMatrixFactor!=null) BeforeMatrixFactor.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("WithTwoDimensionsCreate(\n");

        if(BeforeMatrixFactor!=null)
            buffer.append(BeforeMatrixFactor.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [WithTwoDimensionsCreate]");
        return buffer.toString();
    }
}
