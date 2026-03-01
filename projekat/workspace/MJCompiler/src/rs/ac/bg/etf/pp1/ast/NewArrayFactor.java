// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class NewArrayFactor extends Factor {

    private GlobalVarType GlobalVarType;
    private BeforeNewArrayBracket BeforeNewArrayBracket;
    private Expr Expr;
    private TwoDimensionCreate TwoDimensionCreate;

    public NewArrayFactor (GlobalVarType GlobalVarType, BeforeNewArrayBracket BeforeNewArrayBracket, Expr Expr, TwoDimensionCreate TwoDimensionCreate) {
        this.GlobalVarType=GlobalVarType;
        if(GlobalVarType!=null) GlobalVarType.setParent(this);
        this.BeforeNewArrayBracket=BeforeNewArrayBracket;
        if(BeforeNewArrayBracket!=null) BeforeNewArrayBracket.setParent(this);
        this.Expr=Expr;
        if(Expr!=null) Expr.setParent(this);
        this.TwoDimensionCreate=TwoDimensionCreate;
        if(TwoDimensionCreate!=null) TwoDimensionCreate.setParent(this);
    }

    public GlobalVarType getGlobalVarType() {
        return GlobalVarType;
    }

    public void setGlobalVarType(GlobalVarType GlobalVarType) {
        this.GlobalVarType=GlobalVarType;
    }

    public BeforeNewArrayBracket getBeforeNewArrayBracket() {
        return BeforeNewArrayBracket;
    }

    public void setBeforeNewArrayBracket(BeforeNewArrayBracket BeforeNewArrayBracket) {
        this.BeforeNewArrayBracket=BeforeNewArrayBracket;
    }

    public Expr getExpr() {
        return Expr;
    }

    public void setExpr(Expr Expr) {
        this.Expr=Expr;
    }

    public TwoDimensionCreate getTwoDimensionCreate() {
        return TwoDimensionCreate;
    }

    public void setTwoDimensionCreate(TwoDimensionCreate TwoDimensionCreate) {
        this.TwoDimensionCreate=TwoDimensionCreate;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobalVarType!=null) GlobalVarType.accept(visitor);
        if(BeforeNewArrayBracket!=null) BeforeNewArrayBracket.accept(visitor);
        if(Expr!=null) Expr.accept(visitor);
        if(TwoDimensionCreate!=null) TwoDimensionCreate.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVarType!=null) GlobalVarType.traverseTopDown(visitor);
        if(BeforeNewArrayBracket!=null) BeforeNewArrayBracket.traverseTopDown(visitor);
        if(Expr!=null) Expr.traverseTopDown(visitor);
        if(TwoDimensionCreate!=null) TwoDimensionCreate.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVarType!=null) GlobalVarType.traverseBottomUp(visitor);
        if(BeforeNewArrayBracket!=null) BeforeNewArrayBracket.traverseBottomUp(visitor);
        if(Expr!=null) Expr.traverseBottomUp(visitor);
        if(TwoDimensionCreate!=null) TwoDimensionCreate.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("NewArrayFactor(\n");

        if(GlobalVarType!=null)
            buffer.append(GlobalVarType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(BeforeNewArrayBracket!=null)
            buffer.append(BeforeNewArrayBracket.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(Expr!=null)
            buffer.append(Expr.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(TwoDimensionCreate!=null)
            buffer.append(TwoDimensionCreate.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [NewArrayFactor]");
        return buffer.toString();
    }
}
