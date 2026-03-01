// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class Program implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private ProgName ProgName;
    private NamespaceList NamespaceList;
    private GlobalDeclarations GlobalDeclarations;
    private MethodDeclListWrapper MethodDeclListWrapper;

    public Program (ProgName ProgName, NamespaceList NamespaceList, GlobalDeclarations GlobalDeclarations, MethodDeclListWrapper MethodDeclListWrapper) {
        this.ProgName=ProgName;
        if(ProgName!=null) ProgName.setParent(this);
        this.NamespaceList=NamespaceList;
        if(NamespaceList!=null) NamespaceList.setParent(this);
        this.GlobalDeclarations=GlobalDeclarations;
        if(GlobalDeclarations!=null) GlobalDeclarations.setParent(this);
        this.MethodDeclListWrapper=MethodDeclListWrapper;
        if(MethodDeclListWrapper!=null) MethodDeclListWrapper.setParent(this);
    }

    public ProgName getProgName() {
        return ProgName;
    }

    public void setProgName(ProgName ProgName) {
        this.ProgName=ProgName;
    }

    public NamespaceList getNamespaceList() {
        return NamespaceList;
    }

    public void setNamespaceList(NamespaceList NamespaceList) {
        this.NamespaceList=NamespaceList;
    }

    public GlobalDeclarations getGlobalDeclarations() {
        return GlobalDeclarations;
    }

    public void setGlobalDeclarations(GlobalDeclarations GlobalDeclarations) {
        this.GlobalDeclarations=GlobalDeclarations;
    }

    public MethodDeclListWrapper getMethodDeclListWrapper() {
        return MethodDeclListWrapper;
    }

    public void setMethodDeclListWrapper(MethodDeclListWrapper MethodDeclListWrapper) {
        this.MethodDeclListWrapper=MethodDeclListWrapper;
    }

    public SyntaxNode getParent() {
        return parent;
    }

    public void setParent(SyntaxNode parent) {
        this.parent=parent;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line=line;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ProgName!=null) ProgName.accept(visitor);
        if(NamespaceList!=null) NamespaceList.accept(visitor);
        if(GlobalDeclarations!=null) GlobalDeclarations.accept(visitor);
        if(MethodDeclListWrapper!=null) MethodDeclListWrapper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ProgName!=null) ProgName.traverseTopDown(visitor);
        if(NamespaceList!=null) NamespaceList.traverseTopDown(visitor);
        if(GlobalDeclarations!=null) GlobalDeclarations.traverseTopDown(visitor);
        if(MethodDeclListWrapper!=null) MethodDeclListWrapper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ProgName!=null) ProgName.traverseBottomUp(visitor);
        if(NamespaceList!=null) NamespaceList.traverseBottomUp(visitor);
        if(GlobalDeclarations!=null) GlobalDeclarations.traverseBottomUp(visitor);
        if(MethodDeclListWrapper!=null) MethodDeclListWrapper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("Program(\n");

        if(ProgName!=null)
            buffer.append(ProgName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(NamespaceList!=null)
            buffer.append(NamespaceList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(GlobalDeclarations!=null)
            buffer.append(GlobalDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclListWrapper!=null)
            buffer.append(MethodDeclListWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [Program]");
        return buffer.toString();
    }
}
