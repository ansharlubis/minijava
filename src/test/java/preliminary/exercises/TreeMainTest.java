package preliminary.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TreeMainTest {

  @Test
  public void testInsert() {
    assertEquals(new Tree(null, "a", null).toString(),
                 TreeMain.insert("a", null).toString(), "null");
    assertEquals(new Tree(new Tree(null, "s", null), "t", null).toString(),
                 TreeMain.insert("s", new Tree(null, "t", null)).toString(), "left");
    assertEquals(new Tree(null, "a", new Tree(null, "b", null)).toString(),
                 TreeMain.insert("b", new Tree(null, "a", null)).toString(), "right");
  }

  @Test
  public void testMember() {
    assertEquals(true, TreeMain.member("a", new Tree(null, "a", null)));
    assertEquals(false, TreeMain.member("b", new Tree(null, "a", null)));
    assertEquals(true, TreeMain.member("s", new Tree(new Tree(null, "s", null), "t", null)));
    assertEquals(false, TreeMain.member("b", new Tree(new Tree(null, "s", null), "t", null)));

  }
}