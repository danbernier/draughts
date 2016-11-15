package signals;

import processing.core.PApplet;

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
