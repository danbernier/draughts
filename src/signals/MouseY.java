package signals;

import processing.core.PApplet;

/*cheat
 * A signal that emits float values pointing to the mouse's current vertical
 * position.  Based on Processing's `mouseY` value.
 * 
 * See Mouse and MouseX.
 */

public class MouseY implements Signal<Float> {
  private PApplet sketch;

  public MouseY(PApplet sketch) {
    this.sketch = sketch;
  }

  public Float current() {
    return new Float(sketch.mouseY);
  }
}
