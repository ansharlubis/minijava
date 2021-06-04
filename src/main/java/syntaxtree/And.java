package syntaxtree;

import visitor.*;
import visitor.TypeCheckerVisitor.TypeAssignVisitor;

public class And extends Exp {
    public Exp e1;
    public Exp e2;
    public And(Exp a1, Exp a2) {
        e1 = a1; e2 = a2;
    }
    public void accept(Visitor v) { v.visit(this); }
    public Type accept(TypeAssignVisitor v) { return v.visit(this); }
}
