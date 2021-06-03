package syntaxtree;

import visitor.Visitor;

public class ArrayLength extends Exp  {
    public Exp e;
    public ArrayLength(Exp a1) {
        e = a1;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
