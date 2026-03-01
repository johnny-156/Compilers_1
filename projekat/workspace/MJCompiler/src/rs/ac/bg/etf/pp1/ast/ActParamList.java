// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class ActParamList extends ActualParamList {

    private ActualParamList ActualParamList;
    private ExprInActParam ExprInActParam;

    public ActParamList (ActualParamList ActualParamList, ExprInActParam ExprInActParam) {
        this.ActualParamList=ActualParamList;
        if(ActualParamList!=null) ActualParamList.setParent(this);
        this.ExprInActParam=ExprInActParam;
        if(ExprInActParam!=null) ExprInActParam.setParent(this);
    }

    public ActualParamList getActualParamList() {
        return ActualParamList;
    }

    public void setActualParamList(ActualParamList ActualParamList) {
        this.ActualParamList=ActualParamList;
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
        if(ActualParamList!=null) ActualParamList.accept(visitor);
        if(ExprInActParam!=null) ExprInActParam.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ActualParamList!=null) ActualParamList.traverseTopDown(visitor);
        if(ExprInActParam!=null) ExprInActParam.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ActualParamList!=null) ActualParamList.traverseBottomUp(visitor);
        if(ExprInActParam!=null) ExprInActParam.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ActParamList(\n");

        if(ActualParamList!=null)
            buffer.append(ActualParamList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ExprInActParam!=null)
            buffer.append(ExprInActParam.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ActParamList]");
        return buffer.toString();
    }
}
