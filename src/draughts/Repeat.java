package draughts;

import processing.core.PApplet;

/*cheat
 * Repeats a list of Draughts a given number of times. E.g. `new Repeat(3, A,
 * B)` would draw: A, B, A, B, A, B.
 */

public class Repeat implements Draught {
  private Draught[] commands;
  private int times;
  public Repeat(int times, Draught... draughts) {
    this.times = times;
    this.commands = draughts;
  }
  public void draw(PApplet sketch) {
    for (int i = 0; i < times; i++) {
      for (Draught c : commands) {
        c.draw(sketch);
      }
    }
  }
}
