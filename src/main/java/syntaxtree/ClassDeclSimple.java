package syntaxtree;

import visitor.Visitor;

public class ClassDeclSimple extends ClassDecl {
    public Identifier i;
    public VarDeclList vl;
    public MethodDeclList ml;
    public ClassDeclSimple(Identifier a1, VarDeclList a2, MethodDeclList a3) {
        i = a1; vl = a2; ml = a3;
    }
    public void accept(Visitor v) { v.visit(this); }
}
