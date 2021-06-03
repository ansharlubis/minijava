package syntaxtree;

import visitor.Visitor;

public class ArrayAssign extends Statement {
    public Identifier i;
    public Exp e1;
    public Exp e2;
    public ArrayAssign(Identifier a1, Exp a2, Exp a3) {
        i = a1; e1 = a2; e2 = a3;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
