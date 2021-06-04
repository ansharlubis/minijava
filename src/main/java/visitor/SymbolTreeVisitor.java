package visitor;

import symbol.Class;
import symbol.*;
import syntaxtree.*;
import java.util.Hashtable;

public class SymbolTreeVisitor implements Visitor {
  private final ErrorMsg error = new ErrorMsg();

  public Table symbolTable = new Table();
  private Class currClass;
  private Method currMethod;

  public void visit(Program n) {
    n.m.accept(this);
    for (int i = 0; i < n.cl.size(); i++) {
      n.cl.elementAt(i).accept(this);
    }
  }

  public void visit(MainClass n) {
    Class mainClass = new Class(n.i1.s, "Object");
    currClass = mainClass;
    Method mainMethod = new Method("main", new IdentifierType("void"));
    currMethod = mainMethod;
    mainClass.addMethod("main", mainMethod);
    mainMethod.addParam(n.i2.toString(), new IdentifierType("String[]"));
    n.s.accept(this);
    symbolTable.put(Symbol.symbol(n.i1.s),mainClass);
  }

  public void visit(ClassDeclSimple n) {
    Symbol s = Symbol.symbol(n.i.s);
    if (symbolTable.containsKey(s)) {
      error.complain("The class " + n.i.s+ " is already defined");
    } else {
      Class cl = new Class(n.i.s, "Object");
      currClass = cl;
      currMethod = null;
      for (int i = 0; i < n.vl.size(); i++) {
        n.vl.elementAt(i).accept(this);
      }
      for (int i = 0; i < n.ml.size(); i++) {
        n.ml.elementAt(i).accept(this);
      }
      symbolTable.put(s,cl);
    }
  }

  public void visit(ClassDeclExtends n) {
    Symbol s = Symbol.symbol(n.i.s);
    if (!symbolTable.containsKey(s)) {
      error.complain("The class " + n.i.s + " is already defined");
    } else {
      Class cl = new Class(n.i.s, n.j.toString());
      currClass = cl;
      currMethod = null;
      for (int i = 0; i < n.vl.size(); i++) {
        n.vl.elementAt(i).accept(this);
      }
      for (int i = 0; i < n.ml.size(); i++) {
        n.ml.elementAt(i).accept(this);
      }
      symbolTable.put(s,cl);
    }
  }

  public void visit(VarDecl n) {
    String id = n.i.s;
    Type t = n.t;

    if (currMethod == null) {
      if (!currClass.addField(id,t)) {
        error.complain(id + " is already defined in " + currClass.getName());
      }
    } else if (!currMethod.addLocal(id,t)) {
      error.complain(id + " is already defined in " + currClass.getName() + "." + currMethod.getName());
    }
  }

  public void visit(MethodDecl n) {
    Type t = n.t;
    String id = n.i.s;
    Method m = new Method(id,t);

    if (!currClass.addMethod(id,m)) {
      error.complain(id + " is already defined in " + currClass.getName());
      return;
    }
    currMethod = m;
    for (int i = 0; i < n.fl.size(); i++) {
      n.fl.elementAt(i).accept(this);
    }
    for (int i = 0; i < n.vl.size(); i++) {
      n.vl.elementAt(i).accept(this);
    }
  }

  public void visit(Formal n) {
    String id = n.i.s;
    Type t = n.t;

    if (!currMethod.addParam(id,t)) {
      error.complain("The parameter " + id + " is a duplicate in " + currClass.getName() + "." + currMethod.getName());
    }
  }

  public void visit(IntArrayType n) {}
  public void visit(BooleanType n) {}
  public void visit(IntegerType n) {}
  public void visit(IdentifierType n) {}
  public void visit(Block n) {}
  public void visit(If n) {}
  public void visit(While n) {}
  public void visit(Print n) {}
  public void visit(Assign n) {}
  public void visit(ArrayAssign n) {}
  public void visit(And n) {}
  public void visit(LessThan n) {}
  public void visit(Plus n) {}
  public void visit(Minus n) {}
  public void visit(Times n) {}
  public void visit(ArrayLookup n) {}
  public void visit(ArrayLength n) {}
  public void visit(Call n) {}
  public void visit(IntegerLiteral n) {}
  public void visit(True n) {}
  public void visit(False n) {}
  public void visit(IdentifierExp n) {}
  public void visit(This n) {}
  public void visit(NewArray n) {}
  public void visit(NewObject n) {}
  public void visit(Not n) {}
  public void visit(Identifier n) {}
}
