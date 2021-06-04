package syntaxtree;

import visitor.TypeCheckerVisitor.TypeAssignVisitor;
import visitor.Visitor;

public class This extends Exp {
    public This() {}
    public void accept(Visitor v) { v.visit(this); }
    public Type accept(TypeAssignVisitor v) { return v.visit(this); }

}
