// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class SimpleFormParam extends FormalParamDecl {

    private GlobalVarType GlobalVarType;
    private String varName;

    public SimpleFormParam (GlobalVarType GlobalVarType, String varName) {
        this.GlobalVarType=GlobalVarType;
        if(GlobalVarType!=null) GlobalVarType.setParent(this);
        this.varName=varName;
    }

    public GlobalVarType getGlobalVarType() {
        return GlobalVarType;
    }

    public void setGlobalVarType(GlobalVarType GlobalVarType) {
        this.GlobalVarType=GlobalVarType;
    }

    public String getVarName() {
        return varName;
    }

    public void setVarName(String varName) {
        this.varName=varName;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(GlobalVarType!=null) GlobalVarType.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(GlobalVarType!=null) GlobalVarType.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(GlobalVarType!=null) GlobalVarType.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SimpleFormParam(\n");

        if(GlobalVarType!=null)
            buffer.append(GlobalVarType.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(" "+tab+varName);
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SimpleFormParam]");
        return buffer.toString();
    }
}
