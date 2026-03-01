// generated with ast extension for cup
// version 0.8
// 25/7/2024 22:32:6


package rs.ac.bg.etf.pp1.ast;

public class GlobalVarTypeChooseChar extends GlobalVarTypeChoose {

    public GlobalVarTypeChooseChar () {
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void childrenAccept(Visitor visitor) {
    }

    public void traverseTopDown(Visitor visitor) {
        accept(visitor);
    }

    public void traverseBottomUp(Visitor visitor) {
        accept(visitor);
    }

    public String toString(String tab) {
        StringBuffer buffer=new StringBuffer();
        buffer.append(tab);
        buffer.append("GlobalVarTypeChooseChar(\n");

        buffer.append(tab);
        buffer.append(") [GlobalVarTypeChooseChar]");
        return buffer.toString();
    }
}
