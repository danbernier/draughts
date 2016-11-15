package signals;

import processing.core.PApplet;
import processing.core.PVector;

public class Mouse implements Signal<PVector> {
  private PApplet sketch;

  public Mouse(PApplet sketch) {
    this.sketch = sketch;
  }

  public PVector current() {
    return new PVector(sketch.mouseX, sketch.mouseY);
  }
}
