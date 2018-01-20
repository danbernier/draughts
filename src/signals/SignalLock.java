package signals;

/*cheat
 * A Signal Adapter that can "lock" the source signal to a certain value; it'll
 * return the first value it gets from the source signal, regardless of what
 * the underlying signal returns (in fact, it won't even call the underlying
 * signal).
 *
 * You can `unlock` the SignalLock, and it'll call the source signal again, and
 * then auto-lock to that new value.
 *
 * This is most useful if you're using a source signal in (say) a Repeat
 * draught, and want to use the same value for each iteration, but on the next
 * frame, advance the source signal.
 */

/**
 * TODO: This seems like it'd be more useful if, when you `unlock` it, it STAYS
 * unlocked, until you lock it again.
 */

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
