package syntaxtree;

import visitor.TypeCheckerVisitor.TypeAssignVisitor;
import visitor.Visitor;

public class True extends Exp {
    public True() {}
    public void accept(Visitor v) { v.visit(this); }
    public Type accept(TypeAssignVisitor v) { return v.visit(this); }

}
