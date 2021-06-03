package preliminary;

public class Table {
  String id; int value; Table tail;
  Table(String i, int v, Table t) { id = i; value = v; tail = t; }
  int lookup(String key) {
    if (id.equals(key)) {
      return value;
    }
    return tail.lookup(key);
  }
}
