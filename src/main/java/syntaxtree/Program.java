package syntaxtree;

import visitor.Visitor;

public class Program {
    public MainClass m;
    public ClassDeclList cl;
    public Program(MainClass a1, ClassDeclList a2) {
        m = a1;
        cl = a2;
    }
    public void accept(Visitor v) {
        v.visit(this);
    }
}
