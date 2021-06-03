package syntaxtree;

import visitor.Visitor;

public class BooleanType extends Type {
    public BooleanType() {}
    public void accept(Visitor v) {
        v.visit(this);
    }
}
