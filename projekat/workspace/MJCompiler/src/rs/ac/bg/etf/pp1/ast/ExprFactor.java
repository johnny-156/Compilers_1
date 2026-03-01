// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class ExprFactor extends Factor {

    private BeforeExpr BeforeExpr;
    private Expr Expr;

    public ExprFactor (BeforeExpr BeforeExpr, Expr Expr) {
        this.BeforeExpr=BeforeExpr;
        if(BeforeExpr!=null) BeforeExpr.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
    }

    public BeforeExpr getBeforeExpr() {
        return BeforeExpr;
    }

    public void setBeforeExpr(BeforeExpr BeforeExpr) {
        this.BeforeExpr=BeforeExpr;
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
        if(BeforeExpr!=null) BeforeExpr.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BeforeExpr!=null) BeforeExpr.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BeforeExpr!=null) BeforeExpr.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ExprFactor(\n");

        if(BeforeExpr!=null)
            buffer.append(BeforeExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ExprFactor]");
        return buffer.toString();
    }
}
