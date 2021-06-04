package symbol;

import syntaxtree.Type;

import java.util.Hashtable;

public class Class {
  private final String name;
  private final String parent;
  private final Hashtable<Symbol,Type> fieldTable;
  private final Hashtable<Symbol,Method> methodTable;

  public Class(String n, String p) {
    name = n; parent = p;
    fieldTable = new Hashtable<>(); methodTable = new Hashtable<>();
  }

  public String getName() { return name; }

  public boolean hasField(Symbol id) { return fieldTable.containsKey(id); }

  public boolean hasMethod(Symbol id) { return methodTable.containsKey(id); }

  public Type getField(Symbol id) { return fieldTable.get(id); }

  public Method getMethod(Symbol id) { return methodTable.get(id); }

  public boolean addField(String id, Type t) {
    Symbol s = Symbol.symbol(id);
    for (Symbol o: fieldTable.keySet()) {
      if (o == s) return false;
    }
    fieldTable.put(s,t);
    return true;
  }

  public boolean addMethod(String id, Method m) {
    Symbol s = Symbol.symbol(id);
    for (Symbol o: methodTable.keySet()) {
      if (o == s) return false;
    }
    methodTable.put(s,m);
    return true;
  }

  public String prettyPrint() {
    StringBuilder res = new StringBuilder();
    res.append(name);
    res.append(" <: ");
    res.append(parent);
    res.append(" {\n");
    for (Symbol s: fieldTable.keySet()) {
      Type t = fieldTable.get(s);
      res.append("  ");
      res.append(s + " " + t.toString());
      res.append("\n");
    }
    for (Symbol s: methodTable.keySet()) {
      res.append(methodTable.get(s).prettyPrint());
    }
    res.append("}\n\n");
    return res.toString();
  }
}
