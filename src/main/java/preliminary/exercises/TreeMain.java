package preliminary.exercises;

public class TreeMain {

  static public Tree insert(String key, Tree t) {
    if (t == null) {
      return new Tree(null, key, null);
    } else if (key.compareTo(t.key) < 0) {
      return new Tree(insert(key, t.left), t.key, t.right);
    } else if (key.compareTo(t.key) > 0) {
      return new Tree(t.left, t.key, insert(key, t.right));
    } else {
      return new Tree(t.left, key, t.right);
    }
  }

  static boolean member(String k, Tree t) {
    if (t == null) {
      return false;
    } else if (k.compareTo(t.key) == 0) {
      return true;
    } else if (k.compareTo(t.key) > 0) {
      return member(k, t.right);
    } else {
      return member(k, t.left);
    }
  }

}
