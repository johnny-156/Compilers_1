// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class SingleGlobalVarList extends GlobalVarList {

    private GlobalVarList GlobalVarList;
    private GlobalVarOption GlobalVarOption;

    public SingleGlobalVarList (GlobalVarList GlobalVarList, GlobalVarOption GlobalVarOption) {
        this.GlobalVarList=GlobalVarList;
        if(GlobalVarList!=null) GlobalVarList.setParent(this);
        this.GlobalVarOption=GlobalVarOption;
        if(GlobalVarOption!=null) GlobalVarOption.setParent(this);
    }

    public GlobalVarList getGlobalVarList() {
        return GlobalVarList;
    }

    public void setGlobalVarList(GlobalVarList GlobalVarList) {
        this.GlobalVarList=GlobalVarList;
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
        if(GlobalVarList!=null) GlobalVarList.accept(visitor);
        if(GlobalVarOption!=null) GlobalVarOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVarList!=null) GlobalVarList.traverseTopDown(visitor);
        if(GlobalVarOption!=null) GlobalVarOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVarList!=null) GlobalVarList.traverseBottomUp(visitor);
        if(GlobalVarOption!=null) GlobalVarOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleGlobalVarList(\n");

        if(GlobalVarList!=null)
            buffer.append(GlobalVarList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalVarOption!=null)
            buffer.append(GlobalVarOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleGlobalVarList]");
        return buffer.toString();
    }
}
