package syntaxtree;

import visitor.Visitor;

public class While extends Statement {
    public Exp e;
    public Statement s;
    public While(Exp a1, Statement a2) {
        e = a1; s = a2;
    }
    public void accept(Visitor v) { v.visit(this); }

}
