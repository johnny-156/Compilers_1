// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class GlobalVarListSingleGlobalVar extends GlobalVarList {

    private GlobalVarOption GlobalVarOption;

    public GlobalVarListSingleGlobalVar (GlobalVarOption GlobalVarOption) {
        this.GlobalVarOption=GlobalVarOption;
        if(GlobalVarOption!=null) GlobalVarOption.setParent(this);
    }

    public GlobalVarOption getGlobalVarOption() {
        return GlobalVarOption;
    }

    public void setGlobalVarOption(GlobalVarOption GlobalVarOption) {
        this.GlobalVarOption=GlobalVarOption;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobalVarOption!=null) GlobalVarOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVarOption!=null) GlobalVarOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVarOption!=null) GlobalVarOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVarListSingleGlobalVar(\n");

        if(GlobalVarOption!=null)
            buffer.append(GlobalVarOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [GlobalVarListSingleGlobalVar]");
        return buffer.toString();
    }
}
