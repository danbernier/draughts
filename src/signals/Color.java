package signals;

import processing.core.PApplet;

/*cheat
 * A signal of Colors, made by combining three Signals - one for red, one for
 * green, one for blue - into a Processing color.
 *
 * The signals don't have to actually be RGB; if the Processing sketch is in
 * HSB, that's how to think of these. The signals should return values in the
 * range that's acceptable to Processing's `color` function. If you've set
 * `colorMode(HSB, 360, 100, 100)`, then the first signal should return 0..360,
 * and the others should return 0..100.
 */

public class Color implements Signal<Integer> {
  private PApplet sketch;
  private Signal<Float> r;
  private Signal<Float> g;
  private Signal<Float> b;

  public Color(PApplet sketch, Signal<Float> r, Signal<Float> g, Signal<Float> b) {
    this.sketch = sketch;
    this.r = r;
    this.g = g;
    this.b = b;
  }

  public Integer current() {
    return sketch.color(r.current(), g.current(), b.current());
  }
}
