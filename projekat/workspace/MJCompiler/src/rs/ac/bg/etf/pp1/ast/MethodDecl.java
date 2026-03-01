// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class MethodDecl implements SyntaxNode {

    private SyntaxNode parent;
    private int line;
    private RetTypeWrapper RetTypeWrapper;
    private MethName MethName;
    private MethLPAREN MethLPAREN;
    private FormPars FormPars;
    private VarDeclRootList VarDeclRootList;
    private MethLBRACE MethLBRACE;
    private StatementListWrapper StatementListWrapper;

    public MethodDecl (RetTypeWrapper RetTypeWrapper, MethName MethName, MethLPAREN MethLPAREN, FormPars FormPars, VarDeclRootList VarDeclRootList, MethLBRACE MethLBRACE, StatementListWrapper StatementListWrapper) {
        this.RetTypeWrapper=RetTypeWrapper;
        if(RetTypeWrapper!=null) RetTypeWrapper.setParent(this);
        this.MethName=MethName;
        if(MethName!=null) MethName.setParent(this);
        this.MethLPAREN=MethLPAREN;
        if(MethLPAREN!=null) MethLPAREN.setParent(this);
        this.FormPars=FormPars;
        if(FormPars!=null) FormPars.setParent(this);
        this.VarDeclRootList=VarDeclRootList;
        if(VarDeclRootList!=null) VarDeclRootList.setParent(this);
        this.MethLBRACE=MethLBRACE;
        if(MethLBRACE!=null) MethLBRACE.setParent(this);
        this.StatementListWrapper=StatementListWrapper;
        if(StatementListWrapper!=null) StatementListWrapper.setParent(this);
    }

    public RetTypeWrapper getRetTypeWrapper() {
        return RetTypeWrapper;
    }

    public void setRetTypeWrapper(RetTypeWrapper RetTypeWrapper) {
        this.RetTypeWrapper=RetTypeWrapper;
    }

    public MethName getMethName() {
        return MethName;
    }

    public void setMethName(MethName MethName) {
        this.MethName=MethName;
    }

    public MethLPAREN getMethLPAREN() {
        return MethLPAREN;
    }

    public void setMethLPAREN(MethLPAREN MethLPAREN) {
        this.MethLPAREN=MethLPAREN;
    }

    public FormPars getFormPars() {
        return FormPars;
    }

    public void setFormPars(FormPars FormPars) {
        this.FormPars=FormPars;
    }

    public VarDeclRootList getVarDeclRootList() {
        return VarDeclRootList;
    }

    public void setVarDeclRootList(VarDeclRootList VarDeclRootList) {
        this.VarDeclRootList=VarDeclRootList;
    }

    public MethLBRACE getMethLBRACE() {
        return MethLBRACE;
    }

    public void setMethLBRACE(MethLBRACE MethLBRACE) {
        this.MethLBRACE=MethLBRACE;
    }

    public StatementListWrapper getStatementListWrapper() {
        return StatementListWrapper;
    }

    public void setStatementListWrapper(StatementListWrapper StatementListWrapper) {
        this.StatementListWrapper=StatementListWrapper;
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
        if(RetTypeWrapper!=null) RetTypeWrapper.accept(visitor);
        if(MethName!=null) MethName.accept(visitor);
        if(MethLPAREN!=null) MethLPAREN.accept(visitor);
        if(FormPars!=null) FormPars.accept(visitor);
        if(VarDeclRootList!=null) VarDeclRootList.accept(visitor);
        if(MethLBRACE!=null) MethLBRACE.accept(visitor);
        if(StatementListWrapper!=null) StatementListWrapper.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(RetTypeWrapper!=null) RetTypeWrapper.traverseTopDown(visitor);
        if(MethName!=null) MethName.traverseTopDown(visitor);
        if(MethLPAREN!=null) MethLPAREN.traverseTopDown(visitor);
        if(FormPars!=null) FormPars.traverseTopDown(visitor);
        if(VarDeclRootList!=null) VarDeclRootList.traverseTopDown(visitor);
        if(MethLBRACE!=null) MethLBRACE.traverseTopDown(visitor);
        if(StatementListWrapper!=null) StatementListWrapper.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(RetTypeWrapper!=null) RetTypeWrapper.traverseBottomUp(visitor);
        if(MethName!=null) MethName.traverseBottomUp(visitor);
        if(MethLPAREN!=null) MethLPAREN.traverseBottomUp(visitor);
        if(FormPars!=null) FormPars.traverseBottomUp(visitor);
        if(VarDeclRootList!=null) VarDeclRootList.traverseBottomUp(visitor);
        if(MethLBRACE!=null) MethLBRACE.traverseBottomUp(visitor);
        if(StatementListWrapper!=null) StatementListWrapper.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("MethodDecl(\n");

        if(RetTypeWrapper!=null)
            buffer.append(RetTypeWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethName!=null)
            buffer.append(MethName.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethLPAREN!=null)
            buffer.append(MethLPAREN.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(FormPars!=null)
            buffer.append(FormPars.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(VarDeclRootList!=null)
            buffer.append(VarDeclRootList.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(MethLBRACE!=null)
            buffer.append(MethLBRACE.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        if(StatementListWrapper!=null)
            buffer.append(StatementListWrapper.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [MethodDecl]");
        return buffer.toString();
    }
}
