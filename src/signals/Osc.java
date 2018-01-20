package signals;

/*cheat
 * An oscillator signal.
 *
 * It's constructed with a `period`, and supports a [fluent builder
 * interface](https://stackoverflow.com/questions/17937755/what-is-the-difference-between-a-fluent-interface-and-the-builder-pattern)
 * for specifying amplitude, phase, and offset (basically, translating the
 * signal up or down - it's the last thing added to the signal value).
 */

public class Osc implements Signal<Float> {
  float period;
  float amp = 1;
  float phase = 0;
  float offset = 0;
  long timestamp;
  float theta = 0;

  public Osc(float period) {
    this.period = period;
    timestamp = System.currentTimeMillis();
  }
  public Osc amp(float a) { this.amp = a; return this; }
  public Osc phase(float p) { this.phase = p; return this; }
  public Osc offset(float o) { this.offset = o; return this; }

  public Float current() {
    long now = System.currentTimeMillis();
    long elapsed = now - timestamp;

    theta += 2 * Math.PI * elapsed / 1000 / period;
    timestamp = now;

    return (float)(Math.sin(theta + phase) * amp) + offset;
  }
}
