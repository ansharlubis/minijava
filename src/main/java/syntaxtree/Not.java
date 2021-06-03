package syntaxtree;

import visitor.Visitor;

public class Not extends Exp {
    public Exp e;
    public Not(Exp a1) {
        e = a1;
    }
    public void accept(Visitor v) { v.visit(this); }

}
