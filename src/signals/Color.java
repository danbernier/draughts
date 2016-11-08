package signals;

import processing.core.PApplet;

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
