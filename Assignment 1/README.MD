<h1>Assignment 1<h1>
<h3>Pass Level</h3>
<p>A grid represents a field, have the cells drawn in <em>different shades of green</em>.&nbsp; The various shades of green are representing different heights of grass.&nbsp; Your randomly chosen shades of green should also include randomly chosen red and blue components, although those will be smaller values naturally.&nbsp; For full marks you must have either a color or a grass height field in your <code>Cell</code> class that is used for the drawing of the cell.</p>
<h3>Credit Level</h3>
<p>Support different types of cell.&nbsp; You should support:</p>
<ul>
<li>Road (shown as dark grey)</li>
<li>Mountain (shown as light grey)</li>
<li>Water (shown as blue)</li>
</ul>
<p>You should populate the grid with cells randomly chosen from road, mountain, water, and grass but with grass being three times more likely than the others.</p>
<p>For full marks, you must use inheritance appropriately in your solution.</p>
<h3>(High) Distinction Level: 🤔</h3>
<p>Expand the stage to have an area on the right for information to be displayed to the player.&nbsp; In this area you should show the characteristics of whatever cell the mouse is currently over.&nbsp; The characteristics are:</p>
<ul>
<li>Type of cell (road, mountain, etc)</li>
<li>The movement cost of that cell</li>
</ul>
<p>Movement cost is calculated according to the following scheme:</p>
<ul>
<li>road movement is always 1</li>
<li>mountain movement is always 10</li>
<li>water movement is always 100</li>
<li>grass movement is calculated as (the green component - 100)/50<br>
<ul>
<li>for example, R:100, G:100, B:100 = movement cost of 0</li>
<li>R:50, G:100, B:50 = movement cost of 0</li>
<li>R:50, G:190, B:50 = movement cost of 1</li>
<li>R:50, G:250, B:50 = movement cost of 3</li>
</ul>
</li>
</ul>
<h3>Above and Beyond (no marks): 🤔</h3>
<p>The terrain does not look very natural because surfaces don't just appear randomly. Find a better way to allocate cells and grass height that creates natural looking terrain. The terrain should still be procedurally generated so that each run of the program has different terrain, but it should be more like real terrain. If you need inspiration, read <a href="http://www.firaxis.com/?/blog/single/procedural-terrain-generation-in-sid-meiers-civilization-v">this blog from the developers of Civilisation</a>. If you attempt this task, include a <span style="font-family: 'courier new', courier, monospace;">ABOVE_AND_BEYOND.md</span> file explaining how your algorithm works and where you found it (if you implemented an existing algorithm).</p>
<h3>Submission</h3>
<p>You must submit a zipped VSCode project. &nbsp;Your maker will download your zip file, open it in VSCode and run it from there. &nbsp;Please don't submit unnecessary temporary files (such as class files) in your zip file.&nbsp;&nbsp;</p></div></div>