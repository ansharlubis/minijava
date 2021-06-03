package preliminary;

public class PrintStm extends Stm {
  public ExpList exps;
  public PrintStm(ExpList e) { exps = e; }
  public int maxargs() { return exps.maxargs(); }
  public Table interpStm(Table t) {
    IntAndTable expsVal = exps.print(t);
    return expsVal.t;
  }
}
