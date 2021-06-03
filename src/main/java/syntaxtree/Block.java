package syntaxtree;

import visitor.Visitor;

public class Block extends Statement {
    public StatementList sl;
    public Block(StatementList a1) {
        sl = a1;
    }
    public void accept(Visitor v) { v.visit(this); }
}
