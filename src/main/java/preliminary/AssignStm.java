package preliminary;

public class AssignStm extends Stm {
  public String id; public Exp exp;
  public AssignStm(String i, Exp e) { id = i; exp = e; }

  public int maxargs() { return exp.maxargs(); }

  public Table interpStm(Table t) {
    IntAndTable expVal = exp.interpExp(t);
    return new Table(id, expVal.i, t);
  }
}
