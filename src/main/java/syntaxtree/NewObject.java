package syntaxtree;

import visitor.Visitor;

public class NewObject extends Exp {
    public Identifier i;
    public NewObject(Identifier a1) {
        i = a1;
    }
    public void accept(Visitor v) { v.visit(this); }

}
