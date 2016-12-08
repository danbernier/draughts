package signals;

import processing.core.PApplet;

public class MouseY implements Signal<Float> {
  private PApplet sketch;

  public MouseY(PApplet sketch) {
    this.sketch = sketch;
  }

  public Float current() {
    return new Float(sketch.mouseY);
  }
}
