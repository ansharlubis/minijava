package syntaxtree;

import visitor.Visitor;

public class Identifier {
    public String s;
    public Identifier(String a1) { s = a1; }
    public void accept(Visitor v) { v.visit(this); }

}
