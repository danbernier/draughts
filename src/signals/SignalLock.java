package signals;

public class SignalLock<T> implements Signal<T> {
  private Signal<T> src;
  private T lockedValue;

  public SignalLock(Signal<T> src) {
    this.src = src;
  }
  public T current() {
    if (lockedValue == null) {
      lockedValue = src.current();
    }
    return lockedValue;
  }
  public void unlock() {
    lockedValue = null;
  }
}
