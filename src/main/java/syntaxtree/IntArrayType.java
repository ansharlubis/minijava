package syntaxtree;

import visitor.Visitor;

public class IntArrayType extends Type {
    public boolean equal(Type t) { return t.equal(this); }
    public boolean equal(BooleanType t) { return false; }
    public boolean equal(IntegerType t) { return false; }
    public boolean equal(IntArrayType t) { return true; }
    public boolean equal(IdentifierType t) { return false; }

    public void accept(Visitor v) { v.visit(this); }
    public String toString() { return "int []"; }
}
