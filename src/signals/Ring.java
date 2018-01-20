package signals;

import processing.core.PApplet;

/*cheat
 * AKA Cycle. The term "Ring" comes from SonicPi. You give it items, and it
 * cycles through them.
 *
 * `new Ring(1, 2)` would emit: 1, 2, 1, 2, 1, 2...
 * `new Ring(7, 8, 9)` would emit: 7, 8, 9, 7, 8, 9...
 */
public class Ring<T> implements Signal<T> {
  private T[] items;
  private int index = -1;

  public Ring(T... items) {
    this.items = items;
  }

  public T current() {
    index = (index + 1) % items.length;
    return items[index];
  }
}
