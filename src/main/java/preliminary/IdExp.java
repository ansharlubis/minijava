package preliminary;

public class IdExp extends Exp {
  public String id;
  public IdExp(String i) { id = i; }
  public int maxargs() { return 0; }
  public IntAndTable interpExp(Table t) { return new IntAndTable(t.lookup(id), t); }
}
