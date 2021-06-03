package preliminary;

public class OpExp extends Exp {
  public Exp left, right; public int oper;
  final public static int Plus=1, Minus=2, Times=3, Div=4;
  public OpExp(Exp l, int o, Exp r) { left = l; oper = o; right = r; }
  public int maxargs() { return 0; }
  public IntAndTable interpExp(Table t) {
    IntAndTable leftVal = left.interpExp(t);
    IntAndTable rightVal = right.interpExp(leftVal.t);
    switch (oper) {
      case Plus: return new IntAndTable(leftVal.i + rightVal.i, rightVal.t);
      case Minus: return new IntAndTable(leftVal.i - rightVal.i, rightVal.t);
      case Times: return new IntAndTable(leftVal.i * rightVal.i, rightVal.t);
      default: return new IntAndTable(leftVal.i / rightVal.i, rightVal.t);
    }
  }
}
