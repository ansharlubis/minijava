package syntaxtree;

import visitor.Visitor;

public class True extends Exp {
    public True() {}
    public void accept(Visitor v) { v.visit(this); }

}
