// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class ConstDeclListSingleConstDecl extends ConstDeclList {

    private ConstDeclOption ConstDeclOption;

    public ConstDeclListSingleConstDecl (ConstDeclOption ConstDeclOption) {
        this.ConstDeclOption=ConstDeclOption;
        if(ConstDeclOption!=null) ConstDeclOption.setParent(this);
    }

    public ConstDeclOption getConstDeclOption() {
        return ConstDeclOption;
    }

    public void setConstDeclOption(ConstDeclOption ConstDeclOption) {
        this.ConstDeclOption=ConstDeclOption;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
        if(ConstDeclOption!=null) ConstDeclOption.accept(visitor);
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
        if(ConstDeclOption!=null) ConstDeclOption.traverseTopDown(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        if(ConstDeclOption!=null) ConstDeclOption.traverseBottomUp(visitor);
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("ConstDeclListSingleConstDecl(\n");

        if(ConstDeclOption!=null)
            buffer.append(ConstDeclOption.toString("  "+tab));
        else
            buffer.append(tab+"  null");
        buffer.append("\n");

        buffer.append(tab);
        buffer.append(") [ConstDeclListSingleConstDecl]");
        return buffer.toString();
    }
}
