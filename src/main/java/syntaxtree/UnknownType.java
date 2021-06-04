package syntaxtree;

public class UnknownType extends IdentifierType {
  public UnknownType() { super("unknown"); }

  public boolean equal(Type t) { return true; }
  public boolean equal(BooleanType t) { return true; }
  public boolean equal(IntegerType t) { return true; }
  public boolean equal(IntArrayType t) { return true; }
  public boolean equal(IdentifierType t) { return true; }
}
