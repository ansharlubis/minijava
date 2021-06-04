package visitor;

import symbol.ErrorMsg;
import symbol.Table;
import symbol.Class;
import symbol.Method;
import symbol.Symbol;
import syntaxtree.*;

public class TypeCheckerVisitor implements Visitor {
  private final ErrorMsg error = new ErrorMsg();
  private Table symbolTable;
  private Class currClass;
  private Method currMethod;
  private TypeAssignVisitor typer = new TypeAssignVisitor();

  public class TypeAssignVisitor {

    public Type visit(And n) {
      if (! (n.e1.accept(this) instanceof BooleanType)) {
        error.complain("The left side of an and expression must be of type boolean");
      }
      if (! (n.e2.accept(this) instanceof BooleanType)) {
        error.complain("The right side of an and expression must be of type boolean");
      }
      return new BooleanType();
    }

    public Type visit(LessThan n) {
      if (! (n.e1.accept(this) instanceof IntegerType)) {
        error.complain("The left side of a less than expression must be of type integer");
      }
      if (! (n.e2.accept(this) instanceof IntegerType)) {
        error.complain("The right side of a less than expression must be of type integer");
      }
      return new BooleanType();
    }

    public Type visit(Plus n) {
      if (! (n.e1.accept(this) instanceof IntegerType)) {
        error.complain("The left side of a plus expression must be of type integer");
      }
      if (! (n.e2.accept(this) instanceof IntegerType)) {
        error.complain("The right side of a plus expression must be of type integer");
      }
      return new IntegerType();
    }

    public Type visit(Minus n) {
      if (! (n.e1.accept(this) instanceof IntegerType)) {
        error.complain("The left side of a minus expression must be of type integer");
      }
      if (! (n.e2.accept(this) instanceof IntegerType)) {
        error.complain("The right side of a minus expression must be of type integer");
      }
      return new IntegerType();
    }

    public Type visit(Times n) {
      if (! (n.e1.accept(this) instanceof IntegerType)) {

        error.complain("The left side of a times expression must be of type integer");
      }
      if (!(n.e2.accept(this) instanceof IntegerType)) {
        error.complain("The right side of a times expression must be of type integer");
      }
      return new IntegerType();
    }

    public Type visit(ArrayLookup n) {
      if (! (n.e1.accept(this) instanceof IntArrayType)) {
        error.complain("Lookup can only be done an array type");
      }
      if (! (n.e2.accept(this) instanceof IntegerType)) {
        error.complain("Array access needs an integer expression");
      }
      return new IntegerType();
    }

    public Type visit(ArrayLength n) {
      if (! (n.e.accept(this) instanceof IntArrayType)) {
        error.complain("Only array object has length");
      }
      return new IntegerType();
    }

    public Type visit(Call n) {
      Type receiver = n.e.accept(this);
      if (!(receiver instanceof UnknownType)) {
        if (!(receiver instanceof IdentifierType)) {
          error.complain("The receiver object does not have method defined");
        } else {
          Symbol cs = Symbol.symbol(((IdentifierType) receiver).s);
          Class c = symbolTable.get(cs);
          if (c != null) {
            Symbol ms = Symbol.symbol(n.i.s);
            Method m = c.getMethod(ms);
            if (m == null) {
              error.complain("The method " + ms + " is not found in class " + cs);
            } else {
              if (n.el.size() != m.params().size()) {
                error.complain("The number of argument given does not match the " +
                        "parameters of the method");
              } else {
                int i = 0;
                boolean flag = true;
                for (Symbol s: m.params().keySet()) {
                  Type paramType = m.params().get(s);
                  Type argType = n.el.elementAt(i).accept(this);
                  if (!paramType.equal(argType)) {
                    flag = false;
                    error.complain("The exp does not match the parameter of " + s);
                  }
                  i++;
                }
                if (flag) {
                  return m.getType();
                }
              }
            }
          }
        }
      }
      return new UnknownType();
    }

    public Type visit(IntegerLiteral n) { return new IntegerType(); }

    public Type visit(True n) { return new BooleanType(); }

    public Type visit(False n) { return new BooleanType(); }

    public Type visit(IdentifierExp n) {
      Symbol id = Symbol.symbol(n.s);

      if (currMethod.hasLocal(id)) { return currMethod.getLocal(id); }
      else if (currMethod.hasParam(id)) { return currMethod.getParam(id); }
      else if (currClass.hasField(id)) { return currClass.getField(id); }

      error.complain("The identifier " + n.s + " is not yet declared");
      return new UnknownType();
    }

    public Type visit(This n) { return new IdentifierType(currClass.getName()); }

    public Type visit(NewArray n) { return new IntArrayType(); }

    public Type visit(NewObject n) {
      Symbol id = Symbol.symbol(n.i.s);
      if (symbolTable.containsKey(id)) {
        return new IdentifierType(symbolTable.get(id).getName());
      }
      error.complain("The class " + n.i.s + " is not defined");
      return new UnknownType();
    }

    public Type visit(Not n) {
      if (!(n.e.accept(this) instanceof BooleanType)) {
        error.complain("Not expression must be applied to a boolean typed expression");
      }
      return new BooleanType();
    }

  }

  public TypeCheckerVisitor(Table t) { symbolTable = t; }

  public void visit(Program n) {
    n.m.accept(this);
    for (int i = 0; i < n.cl.size(); i++) {
      n.cl.elementAt(i).accept(this);
    }
  }

  public void visit(MainClass n) {
    currClass = symbolTable.get(Symbol.symbol(n.i1.s));
    currMethod = currClass.getMethod(Symbol.symbol("main"));
    n.s.accept(this);
  }

  public void visit(ClassDeclSimple n) {
    currClass = symbolTable.get(Symbol.symbol(n.i.s));
    for (int i = 0; i < n.ml.size(); i++) {
      n.ml.elementAt(i).accept(this);
    }
  }

  public void visit(ClassDeclExtends n) {
    currClass = symbolTable.get(Symbol.symbol(n.i.s));
    for (int i = 0; i < n.ml.size(); i++) {
      n.ml.elementAt(i).accept(this);
    }
  }

  public void visit(VarDecl n) {}

  public void visit(MethodDecl n) {
    currMethod = currClass.getMethod(Symbol.symbol(n.i.s));
    for (int i = 0; i < n.sl.size(); i++) {
      n.sl.elementAt(i).accept(this);
    }

    if (!n.e.accept(typer).equal(n.t)) {
      error.complain("The return type doesn't match the return exp");
    }
  }

  public void visit(Formal n) {}
  public void visit(IntArrayType n) {}
  public void visit(BooleanType n) {}
  public void visit(IntegerType n) {}
  public void visit(IdentifierType n) {}

  public void visit(Block n) {
    for (int i = 0; i < n.sl.size(); i++) {
      n.sl.elementAt(i).accept(this);
    }
  }

  public void visit(If n) {
    if (!(n.e.accept(typer) instanceof BooleanType)) {
      error.complain("The if statement requires a boolean typed exp");
    }
    n.s1.accept(this);
    n.s2.accept(this);
  }

  public void visit(While n) {
    if (!(n.e.accept(typer) instanceof BooleanType)) {
      error.complain("The while statement requires a boolean typed exp");
    }
    n.s.accept(this);
  }

  public void visit(Print n) {}

  public void visit(Assign n) {
    Symbol s = Symbol.symbol(n.i.s);
    Type varType = new UnknownType();

    if (currMethod.hasLocal(s)) { varType = currMethod.getLocal(s); }
    else if ( currMethod.hasParam(s)) { varType = currMethod.getParam(s); }
    else if (currClass.hasField(s)) { varType = currClass.getField(s);}

    if (varType instanceof UnknownType) {
      error.complain("The variable " + s + " is not defined yet");
    } else {
      if (!varType.equal(n.e.accept(typer))) {
        error.complain("The exp doesn't match the type of var " + s);
      }
    }
  }

  public void visit(ArrayAssign n) {
    Symbol s = Symbol.symbol(n.i.s);
    Type recType = new UnknownType();

    if (currMethod.hasLocal(s)) { recType = currMethod.getLocal(s); }
    else if (currMethod.hasParam(s)) { recType = currMethod.getParam(s); }
    else if (currClass.hasField(s)) { recType = currClass.getField(s);}

    if (!(recType instanceof IntArrayType)) {
      error.complain("The variable " + s + " is not array type");
    } else {
      if (!(n.e1.accept(typer) instanceof IntegerType)) {
        error.complain("Array access requires integer type");
      }
      if (!(n.e2.accept(typer) instanceof IntegerType)) {
        error.complain("Array assignment requires integer type");
      }
    }
  }

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
