package syntaxtree;

import visitor.Visitor;

public abstract class Statement {
    public abstract void accept(Visitor v);
}
