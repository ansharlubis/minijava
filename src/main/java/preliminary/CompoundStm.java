package preliminary;

public class CompoundStm extends Stm {
  public Stm stm1, stm2;
  public CompoundStm(Stm s1, Stm s2)  { stm1 = s1; stm2 = s2; }
  public int maxargs() { return stm1.maxargs() > stm2.maxargs() ? stm1.maxargs() : stm2.maxargs(); }
  public Table interpStm(Table t) {
    return stm2.interpStm(stm1.interpStm(t));
  }
}
