// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class CompleteNamespaceList extends NamespaceList {

    private NamespaceList NamespaceList;
    private SingleNamespace SingleNamespace;

    public CompleteNamespaceList (NamespaceList NamespaceList, SingleNamespace SingleNamespace) {
        this.NamespaceList=NamespaceList;
        if(NamespaceList!=null) NamespaceList.setParent(this);
        this.SingleNamespace=SingleNamespace;
        if(SingleNamespace!=null) SingleNamespace.setParent(this);
    }

    public NamespaceList getNamespaceList() {
        return NamespaceList;
    }

    public void setNamespaceList(NamespaceList NamespaceList) {
        this.NamespaceList=NamespaceList;
    }

    public SingleNamespace getSingleNamespace() {
        return SingleNamespace;
    }

    public void setSingleNamespace(SingleNamespace SingleNamespace) {
        this.SingleNamespace=SingleNamespace;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(NamespaceList!=null) NamespaceList.accept(visitor);
        if(SingleNamespace!=null) SingleNamespace.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NamespaceList!=null) NamespaceList.traverseTopDown(visitor);
        if(SingleNamespace!=null) SingleNamespace.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NamespaceList!=null) NamespaceList.traverseBottomUp(visitor);
        if(SingleNamespace!=null) SingleNamespace.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("CompleteNamespaceList(\n");

        if(NamespaceList!=null)
            buffer.append(NamespaceList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(SingleNamespace!=null)
            buffer.append(SingleNamespace.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [CompleteNamespaceList]");
        return buffer.toString();
    }
}
