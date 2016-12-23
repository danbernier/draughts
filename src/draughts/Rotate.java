package draughts;

import processing.core.PApplet;
import signals.*;

public class Rotate implements Draught {
  private Signal<Float> theta;
  public Rotate(float theta) {
    this(new Constant<Float>(theta));
  }
  public Rotate(Signal<Float> theta) {
    this.theta = theta;
  }
  public void draw(PApplet sketch) {
    sketch.rotate(theta.current());
  }
}
