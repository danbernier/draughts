package signals;

import processing.core.PApplet;

public class MouseX implements Signal<Float> {
  private PApplet sketch;

  public MouseX(PApplet sketch) {
    this.sketch = sketch;
  }

  public Float current() {
    return new Float(sketch.mouseX);
  }
}
