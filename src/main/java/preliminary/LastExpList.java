package preliminary;

public class LastExpList extends ExpList {
  public Exp head;
  public LastExpList(Exp h) { head = h; }
  public int length() { return 1; }
  public int maxargs() { return head.maxargs(); }
  public IntAndTable print(Table t) {
    IntAndTable headVal = head.interpExp(t);
    System.out.println(headVal.i);
    return headVal;
  }
}
