package draughts;

import processing.core.PApplet;

public class DrawRect implements Draught {
  private float w;
  private float h;
  public DrawRect(float w, float h) {
    this.w = w;
    this.h = h;
  }
  public void draw(PApplet sketch) {
    sketch.rect(0, 0, w, h);
  }
}
