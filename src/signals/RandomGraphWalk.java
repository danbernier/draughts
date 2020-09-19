package signals;

import java.util.*;

/*cheat
 * Returns a stream of random values between 0 and 1. Implemented via Java's
 * `Random#nextFloat`.
 */

public class RandomGraphWalk<T> implements Signal<T> {
  private Random random = new Random();
  private HashMap<T, HashSet<T>> graph;
  private T x; // x marks the spot

  /*
   * new RandomGraphWalk().link(1, 2, 3).link(2, 3); // 1 -> [2, 3], 2 -> [3]
   *
   * new RandomGraphWalk(hash)
   *
   * new RandomGraphWalk().
   *   link(3, 6, 9, 12, 8, 4).
       link(4, 3, 8, 12, 6, 9, 5).
       link(5, 4, 10, 6).
       link(6, 3, 4, 5, 12, 9, 11, 7, 8).
       link(7, 6, 12, 8).
       link(8, 3, 4, 7, 12, 6, 9).
       link(9, 3, 4, 6, 8, 10, 12).
       link(10, 5, 9, 11).
       link(11, 6, 10, 12).
       link(12, 3, 4, 6, 7, 8, 11, 9);



   new RandomGraphWalk().
     link(3, 6, 9, 12, 4).
     link(4, 8, 12, 6, 3, 7).
     link(5, 10, 8).
     link(6, 3, 4, 12, 9, 8).
     link(7, 4, 10).
     link(8, 4, 5, 12, 6, 11).
     link(9, 3, 6, 12).
     link(10, 5, 7).
     link(11, 8).
     link(12, 3, 4, 6, 8, 9);

   */
  public RandomGraphWalk() {
    this(new HashMap<T, HashSet<T>>());
  }
  public RandomGraphWalk(HashMap<T, HashSet<T>> graph) {
    this.graph = graph;
  }

  public RandomGraphWalk link(T... items) {
    T key = items[0];
    if (graph.get(key) == null) {
      graph.put(key, new HashSet<T>());
    }
    for (int i = 1; i < items.length; i++) {
      graph.get(key).add(items[i]);
    }
    return this; // fluent interface
  }

  public T current() {
    if (x == null) {
      x = sample(graph.keySet());
    } else {
      x = sample(graph.get(x));
    }
    return x;
  }

  private T sample(Set<T> items) {
    int i = random.nextInt(items.size());
    return (T)items.toArray()[i];
  }
}
