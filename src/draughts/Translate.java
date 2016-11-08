package draughts;

import processing.core.PApplet;

public class Translate implements Draught {
  float x;
  float y;
  public Translate(float x, float y) {
    this.x = x;
    this.y = y;
  }
  public void draw(PApplet sketch) {
    sketch.translate(x, y);
  }
}

