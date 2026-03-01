// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class StatementFuncCall extends DesignatorStatement {

    private FuncCallDesignator FuncCallDesignator;
    private ActualPars ActualPars;

    public StatementFuncCall (FuncCallDesignator FuncCallDesignator, ActualPars ActualPars) {
        this.FuncCallDesignator=FuncCallDesignator;
        if(FuncCallDesignator!=null) FuncCallDesignator.setParent(this);
        this.ActualPars=ActualPars;
        if(ActualPars!=null) ActualPars.setParent(this);
    }

    public FuncCallDesignator getFuncCallDesignator() {
        return FuncCallDesignator;
    }

    public void setFuncCallDesignator(FuncCallDesignator FuncCallDesignator) {
        this.FuncCallDesignator=FuncCallDesignator;
    }

    public ActualPars getActualPars() {
        return ActualPars;
    }

    public void setActualPars(ActualPars ActualPars) {
        this.ActualPars=ActualPars;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(FuncCallDesignator!=null) FuncCallDesignator.accept(visitor);
        if(ActualPars!=null) ActualPars.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(FuncCallDesignator!=null) FuncCallDesignator.traverseTopDown(visitor);
        if(ActualPars!=null) ActualPars.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(FuncCallDesignator!=null) FuncCallDesignator.traverseBottomUp(visitor);
        if(ActualPars!=null) ActualPars.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("StatementFuncCall(\n");

        if(FuncCallDesignator!=null)
            buffer.append(FuncCallDesignator.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ActualPars!=null)
            buffer.append(ActualPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [StatementFuncCall]");
        return buffer.toString();
    }
}
