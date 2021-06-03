package syntaxtree;

import visitor.Visitor;

public class If extends Statement {
    public Exp e;
    public Statement s1;
    public Statement s2;
    public If(Exp a1, Statement a2, Statement a3) {
        e = a1; s1 = a2; s2 = a3;
    }
    public void accept(Visitor v) { v.visit(this); }

}
