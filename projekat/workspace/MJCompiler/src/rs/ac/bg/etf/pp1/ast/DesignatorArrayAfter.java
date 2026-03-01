// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class DesignatorArrayAfter extends DesignatorArray {

    private BeforeArrayElementExpr BeforeArrayElementExpr;
    private Expr Expr;
    private TwoDimensionDesignator TwoDimensionDesignator;

    public DesignatorArrayAfter (BeforeArrayElementExpr BeforeArrayElementExpr, Expr Expr, TwoDimensionDesignator TwoDimensionDesignator) {
        this.BeforeArrayElementExpr=BeforeArrayElementExpr;
        if(BeforeArrayElementExpr!=null) BeforeArrayElementExpr.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.TwoDimensionDesignator=TwoDimensionDesignator;
        if(TwoDimensionDesignator!=null) TwoDimensionDesignator.setParent(this);
    }

    public BeforeArrayElementExpr getBeforeArrayElementExpr() {
        return BeforeArrayElementExpr;
    }

    public void setBeforeArrayElementExpr(BeforeArrayElementExpr BeforeArrayElementExpr) {
        this.BeforeArrayElementExpr=BeforeArrayElementExpr;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public TwoDimensionDesignator getTwoDimensionDesignator() {
        return TwoDimensionDesignator;
    }

    public void setTwoDimensionDesignator(TwoDimensionDesignator TwoDimensionDesignator) {
        this.TwoDimensionDesignator=TwoDimensionDesignator;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(BeforeArrayElementExpr!=null) BeforeArrayElementExpr.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
        if(TwoDimensionDesignator!=null) TwoDimensionDesignator.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(BeforeArrayElementExpr!=null) BeforeArrayElementExpr.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(TwoDimensionDesignator!=null) TwoDimensionDesignator.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(BeforeArrayElementExpr!=null) BeforeArrayElementExpr.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(TwoDimensionDesignator!=null) TwoDimensionDesignator.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("DesignatorArrayAfter(\n");

        if(BeforeArrayElementExpr!=null)
            buffer.append(BeforeArrayElementExpr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TwoDimensionDesignator!=null)
            buffer.append(TwoDimensionDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [DesignatorArrayAfter]");
        return buffer.toString();
    }
}
