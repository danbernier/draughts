package signals;

/*cheat
 * Start at zero, and increment the value at the given rate-per-second. A
 * `Speed` at 2 would, after one second, return 0.5, and after two seconds,
 * return 1, etc.
 */

/**
 * TODO: accept a starting value (default to 0).
 */

public class Speed implements Signal<Float> {
  float ratePerSecond;
  long timestamp;
  float value;
  public Speed(float ratePerSecond) {
    this.ratePerSecond = ratePerSecond;
    timestamp = System.currentTimeMillis();
  }

  public Float current() {
    long now = System.currentTimeMillis();
    long elapsed = now - timestamp;

    value += ratePerSecond * elapsed / 1000;
    timestamp = now;

    return value;
  }
}
