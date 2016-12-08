package signals;

public class Shift implements Signal<Float> {
  private Signal<Float> src;
  private float amount;
  public Shift(float amount, Signal<Float> src) {
    this.src = src;
    this.amount = amount;
  }
  public Float current() {
    return src.current() + amount;
  }
}
