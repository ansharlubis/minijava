package syntaxtree;

import visitor.TypeCheckerVisitor.TypeAssignVisitor;
import visitor.Visitor;

public abstract class Exp {
    public abstract void accept(Visitor v);
    public abstract Type accept(TypeAssignVisitor v);
}
