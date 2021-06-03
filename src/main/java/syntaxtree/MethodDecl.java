package syntaxtree;

import visitor.Visitor;

public class MethodDecl {
    public Type t;
    public Identifier i;
    public FormalList fl;
    public VarDeclList vl;
    public StatementList sl;
    public Exp e;
    public MethodDecl(Type a1, Identifier a2, FormalList a3,
                      VarDeclList a4, StatementList a5, Exp a6) {
        t = a1; i = a2; fl = a3; vl = a4; sl = a5; e = a6;
    }
    public void accept(Visitor v) { v.visit(this); }

}
