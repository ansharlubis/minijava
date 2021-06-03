package syntaxtree;

import visitor.Visitor;

public class False extends Exp  {
    public False() {}
    public void accept(Visitor v) { v.visit(this); }

}
