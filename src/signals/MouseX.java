package signals;

import processing.core.PApplet;

/*cheat
 * A signal that emits float values pointing to the mouse's current horizontal
 * position.  Based on Processing's `mouseX` value.
 * 
 * See Mouse and MouseY.
 */

public class MouseX implements Signal<Float> {
  private PApplet sketch;

  public MouseX(PApplet sketch) {
    this.sketch = sketch;
  }

  public Float current() {
    return new Float(sketch.mouseX);
  }
}
