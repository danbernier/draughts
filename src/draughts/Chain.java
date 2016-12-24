package draughts;

import processing.core.PApplet;

/*cheat
 * Draws a list of Draughts together, in order. Useful for when a Draught
 * accepts only one Draught, and you need it to do a number of things (see
 * SineWave, for example).
 */

public class Chain implements Draught {
  private Draught[] commands;
  public Chain(Draught... draughts) {
    this.commands = draughts;
  }
  public void draw(PApplet sketch) {
    for (Draught c : commands) {
      c.draw(sketch);
    }
  }
}

