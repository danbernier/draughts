package draughts;

import processing.core.PApplet;

public class Chain implements Draught {
  private Draught[] commands;
  public Chain(Draught... commands) {
    this.commands = commands;
  }
  public void draw(PApplet sketch) {
    for (Draught c : commands) {
      c.draw(sketch);
    }
  }
}

