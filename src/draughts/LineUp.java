package draughts;

import signals.SignalLock;
import signals.Signal;
import signals.Constant;
import processing.core.PApplet;

public class LineUp implements Draught {
  private SignalLock<Float> length;
  public LineUp(float l) {
    this(new Constant<Float>(l));
	}
  public LineUp(Signal<Float> l) {
    this.length = new SignalLock<Float>(l);
  }
  public void draw(PApplet p) {
    length.unlock();
    p.line(0, 0, 0, -length.current());
  }
  public float getLength() {
    return length.current();
  }
}
