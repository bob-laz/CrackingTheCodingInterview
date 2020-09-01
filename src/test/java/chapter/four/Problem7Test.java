package chapter.four;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class Problem7Test {

  @Test
  public void buildOrderTest() throws Exception {
    String[] projects = new String[]{"A", "B", "C", "D", "E", "F"};
    String[][] dependencies = new String[][]{{"F", "A"}, {"F", "B"}, {"D", "C"}, {"A", "D"},
        {"B", "D"}};

    assertEquals(List.of("E", "F", "A", "B", "D", "C"),
        Problem7.findBuildOrder(projects, dependencies));
    assertEquals(List.of("E", "F", "A", "B", "D", "C"),
        Problem7.findBuildOrderTopological(projects, dependencies));
  }

  @Test
  public void buildOrderTest2() throws Exception {
    String[] projects = new String[]{"A", "B", "C", "D", "E", "F"};
    String[][] dependencies = new String[][]{{"B", "A"}, {"C", "B"}, {"D", "C"}, {"E", "D"},
        {"F", "E"}};

    assertEquals(List.of("F", "E", "D", "C", "B", "A"),
        Problem7.findBuildOrder(projects, dependencies));
    assertEquals(List.of("F", "E", "D", "C", "B", "A"),
        Problem7.findBuildOrderTopological(projects, dependencies));
  }

  @Test
  public void buildOrderTest3() throws Exception {
    String[] projects = new String[]{"A", "B", "C", "D", "E", "F"};
    String[][] dependencies = new String[][]{{"E", "A"}, {"E", "B"}, {"E", "C"}, {"A", "D"},
        {"B", "D"}, {"C", "D"}, {"F", "E"}};

    assertEquals(List.of("F", "E", "A", "B", "C", "D"),
        Problem7.findBuildOrder(projects, dependencies));
    assertEquals(List.of("F", "E", "A", "B", "C", "D"),
        Problem7.findBuildOrderTopological(projects, dependencies));
  }

  @Test
  public void buildOrderTest4() throws Exception {
    String[] projects = new String[]{"A", "B", "C", "D", "E", "F", "G"};
    String[][] dependencies = new String[][]{{"C", "A"}, {"F", "A"}, {"B", "A"}, {"F", "B"},
        {"F", "C"}, {"A", "E"}, {"B", "E"}, {"D", "G"}};

    assertEquals(List.of("D", "F", "G", "B", "C", "A", "E"),
        Problem7.findBuildOrder(projects, dependencies));
    assertEquals(List.of("D", "F", "G", "B", "C", "A", "E"),
        Problem7.findBuildOrderTopological(projects, dependencies));
  }

  @Test
  public void buildOrderTestNoOrder1() {
    String[] projects = new String[]{"A", "B"};
    String[][] dependencies = new String[][]{{"A", "B"}, {"B", "A"}};

    assertThrows(Exception.class, () -> Problem7.findBuildOrder(projects, dependencies),
        "No possible build order");
    assertThrows(Exception.class, () -> Problem7.findBuildOrderTopological(projects, dependencies),
        "No possible build order");
  }

  @Test
  public void buildOrderTestNoOrder2() {
    String[] projects = new String[]{"A", "B", "C", "D", "E", "F"};
    String[][] dependencies = new String[][]{{"B", "A"}, {"C", "B"}, {"D", "C"}, {"E", "D"},
        {"F", "E"}, {"A", "F"}};

    assertThrows(Exception.class, () -> Problem7.findBuildOrder(projects, dependencies),
        "No possible build order");
    assertThrows(Exception.class, () -> Problem7.findBuildOrderTopological(projects, dependencies),
        "No possible build order");
  }

  @Test
  public void buildOrderTestNoOrder3() {
    String[] projects = new String[]{"A", "B", "C", "D", "E", "F"};
    String[][] dependencies = new String[][]{{"B", "A"}, {"C", "B"}, {"D", "C"}, {"E", "D"},
        {"A", "E"}};

    assertThrows(Exception.class, () -> Problem7.findBuildOrder(projects, dependencies),
        "No possible build order");
    assertThrows(Exception.class, () -> Problem7.findBuildOrderTopological(projects, dependencies),
        "No possible build order");
  }
}