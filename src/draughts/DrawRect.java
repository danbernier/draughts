package draughts;

import signals.*;
import processing.core.PApplet;

/*cheat
 * Draw a rectangle at (0, 0), with the given width and height.
 */

public class DrawRect implements Draught {
  private Signal<Float> x;
  private Signal<Float> y;
  private Signal<Float> width;
  private Signal<Float> height;

  public DrawRect(float width, float height) {
    this(new Constant<Float>(0.0f), new Constant<Float>(0.0f), new Constant<Float>(width), new Constant<Float>(height));
  }
  public DrawRect(Signal<Float> width, Signal<Float> height) {
    this(new Constant<Float>(0.0f), new Constant<Float>(0.0f), width, height);
  }
  public DrawRect(float x, float y, float width, float height) {
    this(new Constant<Float>(x), new Constant<Float>(y), new Constant<Float>(width), new Constant<Float>(height));
  }
  public DrawRect(float x, float y, Signal<Float> width, Signal<Float> height) {
    this(new Constant<Float>(x), new Constant<Float>(y), width, height);
  }
  public DrawRect(Signal<Float> x, Signal<Float> y, Signal<Float> width, Signal<Float> height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public void draw(PApplet sketch) {
    sketch.rect(x.current(), y.current(), width.current(), height.current());
  }
}
