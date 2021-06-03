package preliminary.exercises;

public class Tree {
  public Tree left;
  public String key;
  public Tree right;

  public Tree(Tree l, String k, Tree r) {
    left = l;
    key = k;
    right = r;
  }

  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("Tree(");
    if (left == null) {
      result.append("null, ");
    } else {
      result.append(left.toString());
      result.append(", ");
    }
    result.append(key);
    result.append(", ");
    if (right == null) {
      result.append("null)");
    } else {
      result.append(right.toString());
      result.append(")");
    }
    return result.toString();
  }
}
