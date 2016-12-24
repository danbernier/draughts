package draughts;

import signals.SignalLock;
import signals.Signal;
import signals.Constant;
import processing.core.PApplet;

/*cheat
 * Draw a line, upwards, from (0, 0) to (0, -length).
 */

public class LineUp implements Draught {
  private SignalLock<Float> length;
  public LineUp(float length) {
    this(new Constant<Float>(length));
	}
  public LineUp(Signal<Float> length) {
    this.length = new SignalLock<Float>(length);
  }
  public void draw(PApplet p) {
    length.unlock();
    p.line(0, 0, 0, -length.current());
  }
  public float getLength() {
    return length.current();
  }
}
