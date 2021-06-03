package symbol;

import java.util.Map;
import java.util.Hashtable;

public class Symbol {
    private String name;    // interned String
    private Symbol(String n) { name = n; }

    private static Map<String,Symbol> dict = new Hashtable();

    public static Symbol symbol(String n) {
        String u = n.intern();
        Symbol s = dict.get(u);
        if (s == null) {
            s = new Symbol(u);
            dict.put(u,s);
        }
        return s;
    }

    public String toString() { return name; }
}
