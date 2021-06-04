package symbol;

import java.util.Hashtable;

public class Table {
  private final Hashtable<Symbol,Class> symbolTable = new Hashtable<>();
  public Table() {}
  public void put(Symbol s, Class c) { symbolTable.put(s,c); }
  public boolean containsKey(Symbol id) { return symbolTable.containsKey(id); }
  public Class get(Symbol id) { return symbolTable.get(id); }

  public String prettyPrint() {
    StringBuilder res = new StringBuilder();
    for (Symbol k: symbolTable.keySet()) {
      res.append(symbolTable.get(k).prettyPrint());
    }
    return res.toString();
  }
}
