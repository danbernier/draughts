package signals;

public class Constant<T> implements Signal<T> {
  T val;
  public Constant(T val) {
    this.val = val;
  }
  public T current() {
    return val;
  }
}
