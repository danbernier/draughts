package signals;

/*cheat
 * Always return a constant value. Mostly useful for places where a method
 * expects a Signal, and you really only want to give it a number.
 */

public class Constant<T> implements Signal<T> {
  T val;
  public Constant(T val) {
    this.val = val;
  }
  public T current() {
    return val;
  }
}
