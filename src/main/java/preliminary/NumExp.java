package preliminary;

public class NumExp extends Exp {
  public int num;
  public NumExp(int n) { num = n; }
  public int maxargs() { return 0; }
  public IntAndTable interpExp(Table t) {
    return new IntAndTable(num, t);
  }
}
