// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class ActualParamListSingleActParam extends ActualParamList {

    private ExprInActParam ExprInActParam;

    public ActualParamListSingleActParam (ExprInActParam ExprInActParam) {
        this.ExprInActParam=ExprInActParam;
        if(ExprInActParam!=null) ExprInActParam.setParent(this);
    }

    public ExprInActParam getExprInActParam() {
        return ExprInActParam;
    }

    public void setExprInActParam(ExprInActParam ExprInActParam) {
        this.ExprInActParam=ExprInActParam;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ExprInActParam!=null) ExprInActParam.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ExprInActParam!=null) ExprInActParam.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ExprInActParam!=null) ExprInActParam.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActualParamListSingleActParam(\n");

        if(ExprInActParam!=null)
            buffer.append(ExprInActParam.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActualParamListSingleActParam]");
        return buffer.toString();
    }
}
