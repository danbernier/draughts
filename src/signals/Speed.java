package signals;

public class Speed implements Signal<Float> {
  float ratePerSecond;
  long timestamp;
  float value;
  public Speed(float ratePerSecond) {
    this.ratePerSecond = ratePerSecond;
    timestamp = System.currentTimeMillis();
  }

  public Float current() {
    long now = System.currentTimeMillis();
    long elapsed = now - timestamp;

    value += ratePerSecond * elapsed / 1000;
    timestamp = now;

    return value;
  }
}
