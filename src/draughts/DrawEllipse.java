package draughts;

import signals.*;
import processing.core.PApplet;

/*cheat
 * Draw an ellipse at (x, y) (defaults to (0, 0)), with the given width and height.
 */

public class DrawEllipse implements Draught {
  private Signal<Float> x;
  private Signal<Float> y;
  private Signal<Float> width;
  private Signal<Float> height;

  public DrawEllipse(float width, float height) {
    this(new Constant<Float>(0.0f), new Constant<Float>(0.0f), new Constant<Float>(width), new Constant<Float>(height));
  }
  public DrawEllipse(Signal<Float> width, Signal<Float> height) {
    this(new Constant<Float>(0.0f), new Constant<Float>(0.0f), width, height);
  }
  public DrawEllipse(float x, float y, float width, float height) {
    this(new Constant<Float>(x), new Constant<Float>(y), new Constant<Float>(width), new Constant<Float>(height));
  }
  public DrawEllipse(float x, float y, Signal<Float> width, Signal<Float> height) {
    this(new Constant<Float>(x), new Constant<Float>(y), width, height);
  }
  public DrawEllipse(Signal<Float> x, Signal<Float> y, Signal<Float> width, Signal<Float> height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public void draw(PApplet sketch) {
    sketch.ellipse(x.current(), y.current(), width.current(), height.current());
  }
}
