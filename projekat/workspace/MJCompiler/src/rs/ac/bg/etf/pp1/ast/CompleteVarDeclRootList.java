// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class CompleteVarDeclRootList extends VarDeclRootList {

    private VarDeclRootList VarDeclRootList;
    private VarDeclRoot VarDeclRoot;

    public CompleteVarDeclRootList (VarDeclRootList VarDeclRootList, VarDeclRoot VarDeclRoot) {
        this.VarDeclRootList=VarDeclRootList;
        if(VarDeclRootList!=null) VarDeclRootList.setParent(this);
        this.VarDeclRoot=VarDeclRoot;
        if(VarDeclRoot!=null) VarDeclRoot.setParent(this);
    }

    public VarDeclRootList getVarDeclRootList() {
        return VarDeclRootList;
    }

    public void setVarDeclRootList(VarDeclRootList VarDeclRootList) {
        this.VarDeclRootList=VarDeclRootList;
    }

    public VarDeclRoot getVarDeclRoot() {
        return VarDeclRoot;
    }

    public void setVarDeclRoot(VarDeclRoot VarDeclRoot) {
        this.VarDeclRoot=VarDeclRoot;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(VarDeclRootList!=null) VarDeclRootList.accept(visitor);
        if(VarDeclRoot!=null) VarDeclRoot.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(VarDeclRootList!=null) VarDeclRootList.traverseTopDown(visitor);
        if(VarDeclRoot!=null) VarDeclRoot.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(VarDeclRootList!=null) VarDeclRootList.traverseBottomUp(visitor);
        if(VarDeclRoot!=null) VarDeclRoot.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CompleteVarDeclRootList(\n");

        if(VarDeclRootList!=null)
            buffer.append(VarDeclRootList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclRoot!=null)
            buffer.append(VarDeclRoot.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CompleteVarDeclRootList]");
        return buffer.toString();
    }
}
