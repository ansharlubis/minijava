package syntaxtree;

import visitor.TypeCheckerVisitor.TypeAssignVisitor;
import visitor.Visitor;

public class Call extends Exp  {
    public Exp e;
    public Identifier i;
    public ExpList el;
    public Call(Exp a1, Identifier a2, ExpList a3) {
        e = a1; i = a2; el = a3;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
    public Type accept(TypeAssignVisitor v) { return v.visit(this); }

}
