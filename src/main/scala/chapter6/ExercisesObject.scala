package chapter6

/** 1.
* Write an object Conversions with methods
* inchesToCentimeters,
* gallonsToLiters,
* milesToKilometers.
*/
object Conversions {
  def inchesToCentimeters(inch: Double): Double = 2.54 * inch
  def gallonsToLiters(gallons: Double): Double = 3.78541 * gallons
  def milesToKilometers(milles: Double): Double = 1.60934 * milles
}
/** 2.
* The preceding problem wasn’t very object-oriented. Provide a general superclass
* UnitConversion and define objects InchesToCentimeters, GallonsToLiters,
* and MilesToKilometers that extend it.
*/
class UnitConversion(coefficient: Double) {
  def convert(num: Double): Double = coefficient * num
  def apply(num: Double): Double = convert(num)
}
object InchesToCentimeters extends UnitConversion(2.54)
object GallonsToLiters extends UnitConversion(3.78541)
object MilesToKilometers extends UnitConversion(1.60934)
/** 3.
* Define an Origin object that extends java.awt.Point.
* Why is this not actually a good idea?
* (Have a close look at the methods of the Point class.)
*/
object Origin extends java.awt.Point {}
  /** mb because in same methods we need Point2D or uncomfortable "constructor"*/
/** 4.
 * Define a Point class with a companion object so that you can construct Point instances as
 * Point(3, 4), without using new.
 * */
class Point (x: Int, y: Int) {
  override def toString(): String = s"X: $x  Y: $y"
}
object  Point {
  def apply(x: Int, y: Int): Point = new Point(x, y)
}
/** 5.
 * Write a Scala application, using the App trait,
 * that prints its command-line arguments in reverse order,
 * separated by spaces.
 * For example, scala Reverse Hello World should print World Hello.
 * Note:set in argument same string
 * */
object ReverseWords extends App {
  println(args.toSeq.reverse.mkString(" "))
}
/** 6.
 * Write an enumeration describing the four playing card suits
 * so that the toString method returns ♣, ♦, ♥, or ♠.
 */
object PlayingCards extends Enumeration {
  val clubs: PlayingCards.Value = Value(0, "♣")
  val diamonds: PlayingCards.Value = Value(1, "♦")
  val hearts: PlayingCards.Value = Value(2, "♥")
  val spades: PlayingCards.Value = Value(3, "♠")
}
object ExercisesObject {
  def main(args: Array[String]): Unit = {
    //1
    println(Conversions.gallonsToLiters(50))
    println(Conversions.inchesToCentimeters(50))
    println(Conversions.milesToKilometers(50))
    //2
    val rubToDollar = new UnitConversion(.013)
    println(rubToDollar.convert(48000)) // government say that it middle salary
    println(rubToDollar.convert(32000)) // but in really we have median like
    println(rubToDollar.convert(20000)) // and mode like
    println(rubToDollar.convert(11000)) // minimal need to survive (only food and communal services)
    println(InchesToCentimeters(1))
    println(GallonsToLiters(1))
    println(MilesToKilometers(1))
    //3
    val point = Origin
    point.setLocation(5, 8)
    println(point.x)
    //4
    val point4 = Point(3, 4)
    println(point4)
    //6
    val cards = PlayingCards.values
    for(i <- cards) yield println(i)
  }
}
