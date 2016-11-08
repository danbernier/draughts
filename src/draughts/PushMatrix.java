package draughts;

import processing.core.PApplet;

public class PushMatrix implements Draught {
  private Draught[] commands;
  public PushMatrix(Draught... commands) {
    this.commands = commands;
  }
  public void draw(PApplet sketch) {
    sketch.pushMatrix();
    for (Draught c : commands) {
      c.draw(sketch);
    }
    sketch.popMatrix();
  }
}
