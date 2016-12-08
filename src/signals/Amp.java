package signals;

public class Amp implements Signal<Float> {
  private Signal<Float> src;
  private float amount;
  public Amp(float amount, Signal<Float> src) {
    this.src = src;
    this.amount = amount;
  }
  public Float current() {
    return src.current() * amount;
  }
}
