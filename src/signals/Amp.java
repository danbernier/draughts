package signals;

public class Amp extends Filter {
  private float amount;
  public Amp(float amount, Signal<Float> src) {
    super(src);
    this.amount = amount;
  }
  public Float filter(Float value) {
    return value * amount;
  }
}
