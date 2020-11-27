<statement> := {0-9}+ <static_part>
                {0-9}+ |  <dynamic_part>
                {0-9}+ |  <static_part> <dynamic_part>

<static_part> := <layout> <image_info>
<dynamic_part> := {1-9}+ {<motion_image_path>}+ 

<layout> := vertical | horizontal | superimpose

<image_info> := {1-9}+ {<image_path>}+

<motion_image_path> := {<image_path>} <cordinates> <cordinates>
<image_path> := String

<cordinates> := ({0-90},{0-90})

Single image on a single/range of continuous pages
Mutiple Images on a single/range of continuous pages
#pages vertical #images images...
#pages horizontal #images images...
#pages superimpose #images images...

Single/Mutilple Image transforming with Multiple Static Image
#pages (static_part) 

(dynamic_part)
Motion - #images image_path (startX, startY) (endX, endY)

