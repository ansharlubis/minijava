package syntaxtree;

import visitor.Visitor;

public abstract class Type {
    public abstract boolean equal(Type t);
    public abstract boolean equal(BooleanType t);
    public abstract boolean equal(IntegerType t);
    public abstract boolean equal(IntArrayType t);
    public abstract boolean equal(IdentifierType t);

    public abstract void accept(Visitor v);
}
