# Draughts

A cheatsheet.
[Get all the details.](https://github.com/danbernier/draughts)

[draughts](draughts) | [signals](signals)

## Package: draughts


### Chain


<p>Draws a list of Draughts together, in order. Useful for when a Draught
accepts only one Draught, and you need it to do a number of things (see
SineWave, for example).</p>



* `new Chain(Draught... draughts)`


### Circle


<p>Draw a Draught around the edge of a circle, a given number of times. Radius
defaults to 1, Phase defaults to 0.</p>



* `new Circle(int times, Draught draught)`

* `new Circle(int times, float radius, float phase, Draught draught)`


### DrawRect


<p>Draw a rectangle at (0, 0), with the given width and height.</p>



* `new DrawRect(Signal<Float> width, Signal<Float> height)`

* `new DrawRect(float width, float height)`


### DrawText


<p>Draw a string of text at (0, 0), with the current fill color, font, text
alignment, etc.</p>



* `new DrawText(String text)`


### EquilateralTriangle


<p>Draw an equilateral triangle, pointing up, with the baseline centered at (0,
0).</p>



* `new EquilateralTriangle(Signal<Float> baseWidth)`

* `new EquilateralTriangle(float baseWidth)`


### HexGrid


<p>Draw a Draught repeatedly on a hexagonal grid. You control the width and
height of the grid, and the size of each hexagon (picture it as the distance
between the center of two neighboring hexagons).</p>



* `new HexGrid(float gridWidth, float gridHeight, float cellSize, Draught draught)`


### LineUp


<p>Draw a line, upwards, from (0, 0) to (0, -length).</p>



* `new LineUp(Signal<Float> length)`

* `new LineUp(float length)`


### Maybe


<p>Draw a Draught, but only some percentage of the time.</p>



* `new Maybe(float probability, Draught draught)`


### PushMatrix


<p>Push a new matrix onto the stack, draw the draughts, then pop the matrix
stack.</p>



* `new PushMatrix(Draught... draughts)`


### Repeat


<p>Repeats a list of Draughts a given number of times. E.g. <code>new Repeat(3, A,
B)</code> would draw: A, B, A, B, A, B.</p>



* `new Repeat(int times, Draught... draughts)`


### Rotate





* `new Rotate(Signal<Float> theta)`

* `new Rotate(float theta)`


### Scale





* `new Scale(float amount)`


### SineWave


<p>Draw a Draught, a number of times, laid out along a sine wave.</p>

<p><code>amplitude</code> defaults to 1, <code>phase</code> defaults to 0. The <code>width</code> defaults to 10
* n (it’s weird, maybe we’ll improve that).</p>



* `new SineWave(int n, Draught draught)`

* `new SineWave(int n, float amp, float phase, float width, Draught draught)`


### Translate


<p>Translate the coordinate system to the given position. Just like
Processing’s <code>translate</code> command.</p>



* `new Translate(Signal<Float> x, Signal<Float> y)`

* `new Translate(Signal<PVector> position)`

* `new Translate(float x, float y)`


### style/Fill


<p>Set the current fill color for the sketch. Accepts either a constant color,
or a <code>Signal&lt;Integer&gt;</code>. Accepts integer types because <a href="https://processing.org/reference/color_datatype.html">Processing stores
colors as 32-bit
integers</a>.</p>



* `new Fill(Signal<Integer> colorSignal)`

* `new Fill(int constantColor)`


### style/Stroke


<p>Set the current stroke color for the sketch. Accepts either a constant
color, or a <code>Signal&lt;Integer&gt;</code>. Accepts integer types because <a href="https://processing.org/reference/color_datatype.html">Processing
stores colors as 32-bit
integers</a>.</p>



* `new Stroke(Signal<Integer> colorSignal)`

* `new Stroke(int constantColor)`


### style/StrokeWeight


<p>Set the current stroke-weight for the sketch. Accepts either a constant
weight, or a <code>Signal&lt;Float&gt;</code> to vary the weight.</p>



* `new StrokeWeight(Signal<Float> weightSignal)`

* `new StrokeWeight(float constantWeight)`



---------------

Generated 2018-01-20 17:16:18 -05:00
