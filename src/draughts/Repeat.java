package draughts;

import processing.core.PApplet;

public class Repeat implements Draught {
  private Draught[] commands;
  private int times;
  public Repeat(int times, Draught... commands) {
    this.times = times;
    this.commands = commands;
  }
  public void draw(PApplet sketch) {
    for (int i = 0; i < times; i++) {
      for (Draught c : commands) {
        c.draw(sketch);
      }
    }
  }
}
