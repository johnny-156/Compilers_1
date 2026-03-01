// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class SingleConstDeclaration extends SingleDeclaration {

    private GlobalVarType GlobalVarType;
    private ConstDeclList ConstDeclList;

    public SingleConstDeclaration (GlobalVarType GlobalVarType, ConstDeclList ConstDeclList) {
        this.GlobalVarType=GlobalVarType;
        if(GlobalVarType!=null) GlobalVarType.setParent(this);
        this.ConstDeclList=ConstDeclList;
        if(ConstDeclList!=null) ConstDeclList.setParent(this);
    }

    public GlobalVarType getGlobalVarType() {
        return GlobalVarType;
    }

    public void setGlobalVarType(GlobalVarType GlobalVarType) {
        this.GlobalVarType=GlobalVarType;
    }

    public ConstDeclList getConstDeclList() {
        return ConstDeclList;
    }

    public void setConstDeclList(ConstDeclList ConstDeclList) {
        this.ConstDeclList=ConstDeclList;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobalVarType!=null) GlobalVarType.accept(visitor);
        if(ConstDeclList!=null) ConstDeclList.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVarType!=null) GlobalVarType.traverseTopDown(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVarType!=null) GlobalVarType.traverseBottomUp(visitor);
        if(ConstDeclList!=null) ConstDeclList.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleConstDeclaration(\n");

        if(GlobalVarType!=null)
            buffer.append(GlobalVarType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(ConstDeclList!=null)
            buffer.append(ConstDeclList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleConstDeclaration]");
        return buffer.toString();
    }
}
