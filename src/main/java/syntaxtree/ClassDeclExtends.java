package syntaxtree;

import visitor.Visitor;

public class ClassDeclExtends extends ClassDecl {
    public Identifier i;
    public Identifier j;
    public VarDeclList vl;
    public MethodDeclList ml;
    public ClassDeclExtends(Identifier a1, Identifier a2, VarDeclList a3, MethodDeclList a4) {
        i = a1; j = a2; vl = a3; ml = a4;
    }
    public void accept(Visitor v) { v.visit(this); }
}
