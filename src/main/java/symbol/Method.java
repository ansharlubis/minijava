package symbol;

import syntaxtree.Type;

import java.util.HashMap;
import java.util.Hashtable;

public class Method {
  private final String name;
  private final Type returnType;
  private final HashMap<Symbol,Type> paramTable;
  private final Hashtable<Symbol,Type> localTable;

  public Method(String n, Type t) {
    name = n; returnType = t;
    paramTable = new HashMap<>(); localTable = new Hashtable<>();
  }

  public Type getParam(Symbol id) { return paramTable.get(id); }

  public Type getLocal(Symbol id) { return localTable.get(id) ;}

  public boolean hasParam(Symbol id) { return paramTable.containsKey(id); }

  public boolean hasLocal(Symbol id) { return localTable.containsKey(id); }

  public HashMap<Symbol,Type> params() { return paramTable; }

  public String getName() { return name; }

  public Type getType() { return returnType; }

  public boolean addParam(String id, Type t) {
    Symbol s = Symbol.symbol(id);
    for (Symbol p: paramTable.keySet()) {
      if (p == s) return false;
    }
    paramTable.put(s,t);
    return true;
  }

  public boolean addLocal(String id, Type t) {
    Symbol s = Symbol.symbol(id);
    for (Symbol l: localTable.keySet()) {
      if (l == s) return false;
    }
    localTable.put(s,t);
    return true;
  }

  public String prettyPrint() {
    StringBuilder res = new StringBuilder();
    res.append("  ");
    res.append(returnType.toString());
    res.append(" ");
    res.append(name);
    res.append("(");
    boolean init = true;
    for (Symbol param: paramTable.keySet()) {
      if (!init) {
        res.append(", ");
      }
      res.append(paramTable.get(param).toString());
      res.append(" ");
      res.append(param.toString());
      init = false;
    }
    res.append(")\n");
    for (Symbol local: localTable.keySet()) {
      res.append("    ");
      res.append(localTable.get(local).toString());
      res.append(" ");
      res.append(local.toString());
      res.append("\n");
    }
    return res.toString();
  }

}
