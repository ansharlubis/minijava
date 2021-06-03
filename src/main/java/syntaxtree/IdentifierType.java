package syntaxtree;

import visitor.Visitor;

public class IdentifierType extends Type {
    public String s;
    public IdentifierType(String a1) {
        s = a1;
    }
    public void accept(Visitor v) { v.visit(this); }

}
