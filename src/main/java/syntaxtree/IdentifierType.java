package syntaxtree;

import visitor.Visitor;
import visitor.TypeCheckerVisitor.TypeAssignVisitor;

public class IdentifierType extends Type {
    public String s;
    public IdentifierType(String a1) {
        s = a1;
    }

    public boolean equal(Type t) { return t.equal(this); }
    public boolean equal(BooleanType t) { return false; }
    public boolean equal(IntegerType t) { return false; }
    public boolean equal(IntArrayType t) { return false; }
    public boolean equal(IdentifierType t) { return s == t.s; }

    public void accept(Visitor v) { v.visit(this); }
    public String toString() { return s; }
}
