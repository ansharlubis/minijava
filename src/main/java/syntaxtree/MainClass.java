package syntaxtree;

import visitor.Visitor;

public class MainClass {
    public Identifier i1;
    public Identifier i2;
    public Statement s;
    public MainClass(Identifier a1, Identifier a2, Statement a3) {
        i1 = a1; i2 = a2; s = a3;
    }
    public void accept(Visitor v) { v.visit(this); }

}
