package signals;

public class Threshold implements Signal<Boolean> {
  private Osc osc;
  public Threshold(Osc osc) {
    this.osc = osc;
  }
  public Boolean current() {
    return this.osc.current() > 0;
  }
}
