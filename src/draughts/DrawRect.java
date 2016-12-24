package draughts;

import signals.*;
import processing.core.PApplet;

/*cheat
 * Draw a rectangle at (0, 0), with the given width and height.
 */

public class DrawRect implements Draught {
  private Signal<Float> width;
  private Signal<Float> height;
  public DrawRect(float width, float height) {
    this(new Constant<Float>(width), new Constant<Float>(height));
  }
  public DrawRect(Signal<Float> width, Signal<Float> height) {
    this.width = width;
    this.height = height;
  }
  public void draw(PApplet sketch) {
    sketch.rect(0, 0, width.current(), height.current());
  }
}
