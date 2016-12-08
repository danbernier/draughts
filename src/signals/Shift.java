package signals;

public class Shift extends Filter<Float> {
  private float amount;
  public Shift(float amount, Signal<Float> src) {
    super(src);
    this.amount = amount;
  }
  public Float filter(Float value) {
    return value + amount;
  }
}
