// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class SingleVarDeclaration extends SingleDeclaration {

    private GlobalVarType GlobalVarType;
    private GlobalVarList GlobalVarList;

    public SingleVarDeclaration (GlobalVarType GlobalVarType, GlobalVarList GlobalVarList) {
        this.GlobalVarType=GlobalVarType;
        if(GlobalVarType!=null) GlobalVarType.setParent(this);
        this.GlobalVarList=GlobalVarList;
        if(GlobalVarList!=null) GlobalVarList.setParent(this);
    }

    public GlobalVarType getGlobalVarType() {
        return GlobalVarType;
    }

    public void setGlobalVarType(GlobalVarType GlobalVarType) {
        this.GlobalVarType=GlobalVarType;
    }

    public GlobalVarList getGlobalVarList() {
        return GlobalVarList;
    }

    public void setGlobalVarList(GlobalVarList GlobalVarList) {
        this.GlobalVarList=GlobalVarList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobalVarType!=null) GlobalVarType.accept(visitor);
        if(GlobalVarList!=null) GlobalVarList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVarType!=null) GlobalVarType.traverseTopDown(visitor);
        if(GlobalVarList!=null) GlobalVarList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVarType!=null) GlobalVarType.traverseBottomUp(visitor);
        if(GlobalVarList!=null) GlobalVarList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleVarDeclaration(\n");

        if(GlobalVarType!=null)
            buffer.append(GlobalVarType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalVarList!=null)
            buffer.append(GlobalVarList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleVarDeclaration]");
        return buffer.toString();
    }
}
