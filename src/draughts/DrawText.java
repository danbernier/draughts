package draughts;

import processing.core.PApplet;

/*cheat
 * Draw a string of text at (0, 0), with the current fill color, font, text
 * alignment, etc.
 */

public class DrawText implements Draught {
  private String text;
  public DrawText(String text) {
    this.text = text;
  }
  public void draw(PApplet sketch) {
    sketch.text(text, 0, 0);
  }
}
