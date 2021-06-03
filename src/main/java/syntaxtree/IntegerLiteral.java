package syntaxtree;

import visitor.Visitor;

public class IntegerLiteral extends Exp  {
    public int i;
    public IntegerLiteral(int a1) {
        i = a1;
    }
    public void accept(Visitor v) { v.visit(this); }

}
