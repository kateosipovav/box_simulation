//the maximum plant capacity of the box for volume, defined as
//the volume of the box divided by the volume of
//one plant is 33.492220427, which is 33 plants approximtely.
//th volume of one plant is calculated using the half elipsoid formula
//the maximum capacity of the box for surface area is 58.9462752192, which is 58 plants approximately.
//the object will always have enough surface area, but should divide the cube in such areas so that no area is wasted.
 
public class Cubicle {
public static final double SIDE = 50;
public static final double VOLUME = Math.pow(SIDE, 3);
}
 
