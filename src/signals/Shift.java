package signals;

public class Shift extends Filter<Float> {
  /*cheat
   * Shift a signal, additively, by the given `amount`. Or, add `amount` to
   * each value from the source signal.
   */
  private float amount;
  public Shift(float amount, Signal<Float> src) {
    super(src);
    this.amount = amount;
  }
  public Float filter(Float value) {
    return value + amount;
  }
}
