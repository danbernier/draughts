package draughts;

import processing.core.PApplet;

public class DrawText implements Draught {
  private String text;
  public DrawText(String text) {
    this.text = text;
  }
  public void draw(PApplet sketch) {
    sketch.text(text, 0, 0);
  }
}
