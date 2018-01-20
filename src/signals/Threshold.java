package signals;

/*cheat
 * Turn an `Osc` into a stream of booleans, based on whether the oscillator's
 * value is greater than zero.
 *
 * (This one is, admittedly, kind of odd, kind of specific.)
 */

/**
 * TODO: This one's crying out for generalization. Take a stream? Accept a
 * parameter for the threshold?
 */

public class Threshold implements Signal<Boolean> {
  private Osc osc;
  public Threshold(Osc osc) {
    this.osc = osc;
  }
  public Boolean current() {
    return this.osc.current() > 0;
  }
}
