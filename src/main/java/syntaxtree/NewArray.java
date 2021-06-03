package syntaxtree;

import visitor.Visitor;

public class NewArray extends Exp {
    public Exp e;
    public NewArray(Exp a1) {
        e = a1;
    }
    public void accept(Visitor v) { v.visit(this); }

}
