package syntaxtree;

import visitor.TypeCheckerVisitor.TypeAssignVisitor;
import visitor.Visitor;

public class IdentifierExp extends Exp  {
    public String s;
    public IdentifierExp(String a1) {
        s = a1;
    }
    public void accept(Visitor v) { v.visit(this); }
    public Type accept(TypeAssignVisitor v) { return v.visit(this); }

}
