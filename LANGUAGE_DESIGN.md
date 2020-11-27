# Flip Language Design
This file describes the flip language. Following types of flip books can be created using the flip language, although not all of them have been
implemented:
1. (Fully - implemented) Single image on a single/range of continuous pages(i.e. 1-5)
2. (Not Implemented) Mutiple Images on a single/range of continuous pages(i.e. 1-5). Three types of layout are supported for displaying mutiple images on a single page
    1. `vertical` - lays images verically with equal width
    2. `horizontal` - lays images horizontally with equal height
    3. `superimpose` - stacks images on top of each other  
3. (Not Implemented) Single/Mutiple images motion on a range of continuous pages. Every image has a start & end coordinate. Image starts at start cordinate & ends at end cordinate. Motion is shown uniformly across flip pages. Superimpose(default) layout is the only supported layout.
4. (Not Implemented) Single/Mutiple static images with Single/Mutiple images motion.

### How to write flip file?
1. <#pages> superimpose 1 <image_path>
2. Flip file is parsed from top. So pages are added as described by each statement. For example
3. To show `image1` after first image
```
1 superimpose 1 demo\images\childhood.jpg
1 superimpose 1 image1.jpg
```
4. To show `image1` twice on after first image
```
1 superimpose 1 demo\images\childhood.jpg
1 superimpose 1 image1.jpg
```
    

### Flip Language grammar
```
<statement> := {0-9}+ <static_part> 
             | {0-9}+  <dynamic_part>
             | {0-9}+  <static_part> <dynamic_part>

<static_part> := <layout> <image_info>
<dynamic_part> := {1-9}+ {<motion_image_path>}+ 

<layout> := vertical | horizontal | superimpose

<image_info> := {1-9}+ {<image_path>}+
<motion_image_path> := <image_path> <cordinates> <coordinates>
<image_path> := String

<coordinates> := ({0-90},{0-90})
 ```
