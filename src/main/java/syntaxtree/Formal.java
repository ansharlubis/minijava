package syntaxtree;

import visitor.Visitor;

public class Formal {
    public Type t;
    public Identifier i;
    public Formal(Type a1, Identifier a2) {
        t = a1; i = a2;
    }
    public void accept(Visitor v) { v.visit(this); }

}
