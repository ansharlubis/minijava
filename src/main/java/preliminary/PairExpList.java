package preliminary;

public class PairExpList extends ExpList {
  public Exp head; public ExpList tail;
  public PairExpList(Exp h, ExpList t) { head = h; tail = t; }
  public int length() { return 1 + tail.length(); }
  public int maxargs() {
    int length = length(), headArgs = head.maxargs(), tailArgs = tail.maxargs();
    if (length > headArgs && length > tailArgs) { return length; }
    if (headArgs > length && headArgs > tailArgs) { return headArgs; }
    return tailArgs;
  }

  public IntAndTable print(Table t) {
    IntAndTable headVal = head.interpExp(t);
    System.out.print(headVal.i + " ");
    return tail.print(headVal.t);
  }
}
