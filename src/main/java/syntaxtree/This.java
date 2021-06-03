package syntaxtree;

import visitor.Visitor;

public class This extends Exp {
    public This() {}
    public void accept(Visitor v) { v.visit(this); }

}
