package preliminary;

public class EseqExp extends Exp {
  public Stm stm; public Exp exp;
  public EseqExp(Stm s, Exp e) { stm = s; exp = e; }
  public int maxargs() { return stm.maxargs(); }
  public IntAndTable interpExp(Table t) {
    Table st = stm.interpStm(t);
    return exp.interpExp(st);
  }
}
