package draughts;

import processing.core.PApplet;

public class Scale implements Draught {
  float amount;
  public Scale(float amount) {
    this.amount = amount;
  }
  public void draw(PApplet sketch) {
    sketch.scale(amount);
  }
}
