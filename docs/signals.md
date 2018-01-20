# Draughts

A cheatsheet.
[Get all the details.](https://github.com/danbernier/draughts)

[draughts](draughts) | [signals](signals)

## Package: signals


### Amp





* `new Amp(float amount, Signal<Float> src)`


### Color





* `new Color(PApplet sketch, Signal<Float> r, Signal<Float> g, Signal<Float> b)`


### Constant





* `new Constant(T val)`


### Filter





* `new Filter(Signal<T> src)`


### HiPass





* `new HiPass(float threshold, Signal<Float> src)`


### LoPass





* `new LoPass(float threshold, Signal<Float> src)`


### Mouse





* `new Mouse(PApplet sketch)`


### MouseX





* `new MouseX(PApplet sketch)`


### MouseY





* `new MouseY(PApplet sketch)`


### Osc





* `new Osc(float period)`


### PVectorSignal





* `new PVectorSignal(Signal<Float> x, Signal<Float> y)`


### RandomSignal





* `new RandomSignal(float max)`

* `new RandomSignal(float min, float max)`


### Ring





* `new Ring(T... items)`


### Shift





* `new Shift(float amount, Signal<Float> src)`


### Signal






### SignalLock





* `new SignalLock(Signal<T> src)`


### Speed





* `new Speed(float ratePerSecond)`


### Threshold





* `new Threshold(Osc osc)`



---------------

Generated 2018-01-20 17:11:22 -05:00
