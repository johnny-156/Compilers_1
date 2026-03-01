// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class SingleNamespace implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private NameOfNamespace NameOfNamespace;
    private NamespaceDeclarations NamespaceDeclarations;
    private MethodDeclListWrapper MethodDeclListWrapper;

    public SingleNamespace (NameOfNamespace NameOfNamespace, NamespaceDeclarations NamespaceDeclarations, MethodDeclListWrapper MethodDeclListWrapper) {
        this.NameOfNamespace=NameOfNamespace;
        if(NameOfNamespace!=null) NameOfNamespace.setParent(this);
        this.NamespaceDeclarations=NamespaceDeclarations;
        if(NamespaceDeclarations!=null) NamespaceDeclarations.setParent(this);
        this.MethodDeclListWrapper=MethodDeclListWrapper;
        if(MethodDeclListWrapper!=null) MethodDeclListWrapper.setParent(this);
    }

    public NameOfNamespace getNameOfNamespace() {
        return NameOfNamespace;
    }

    public void setNameOfNamespace(NameOfNamespace NameOfNamespace) {
        this.NameOfNamespace=NameOfNamespace;
    }

    public NamespaceDeclarations getNamespaceDeclarations() {
        return NamespaceDeclarations;
    }

    public void setNamespaceDeclarations(NamespaceDeclarations NamespaceDeclarations) {
        this.NamespaceDeclarations=NamespaceDeclarations;
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
        if(NameOfNamespace!=null) NameOfNamespace.accept(visitor);
        if(NamespaceDeclarations!=null) NamespaceDeclarations.accept(visitor);
        if(MethodDeclListWrapper!=null) MethodDeclListWrapper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(NameOfNamespace!=null) NameOfNamespace.traverseTopDown(visitor);
        if(NamespaceDeclarations!=null) NamespaceDeclarations.traverseTopDown(visitor);
        if(MethodDeclListWrapper!=null) MethodDeclListWrapper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(NameOfNamespace!=null) NameOfNamespace.traverseBottomUp(visitor);
        if(NamespaceDeclarations!=null) NamespaceDeclarations.traverseBottomUp(visitor);
        if(MethodDeclListWrapper!=null) MethodDeclListWrapper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("SingleNamespace(\n");

        if(NameOfNamespace!=null)
            buffer.append(NameOfNamespace.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(NamespaceDeclarations!=null)
            buffer.append(NamespaceDeclarations.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethodDeclListWrapper!=null)
            buffer.append(MethodDeclListWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [SingleNamespace]");
        return buffer.toString();
    }
}
