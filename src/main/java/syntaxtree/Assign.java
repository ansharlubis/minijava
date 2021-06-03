package syntaxtree;


import visitor.Visitor;

public class Assign extends Statement {
    public Identifier i;
    public Exp e;
    public Assign(Identifier a1, Exp a2) {
        i = a1; e = a2;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
