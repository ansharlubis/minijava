package syntaxtree;

import visitor.Visitor;

public class Print extends Statement {
    public Exp e;
    public Print(Exp a1) {
        e = a1;
    }
    public void accept(Visitor v) { v.visit(this); }

}
