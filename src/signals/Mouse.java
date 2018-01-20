package signals;

import processing.core.PApplet;
import processing.core.PVector;

/*cheat
 * A signal that emits PVectors pointing to the mouse's current position.
 * Based on Processing's `mouseX` and `mouseY` values.
 * 
 * See MouseX and MouseY.
 */

public class Mouse implements Signal<PVector> {
  private PApplet sketch;

  public Mouse(PApplet sketch) {
    this.sketch = sketch;
  }

  public PVector current() {
    return new PVector(sketch.mouseX, sketch.mouseY);
  }
}
