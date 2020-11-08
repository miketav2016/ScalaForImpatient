package chapter6

/*
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

object ExercisesObject {
  def main(args: Array[String]): Unit = {
    //1
    println(Conversions.gallonsToLiters(50))
    println(Conversions.inchesToCentimeters(50))
    println(Conversions.milesToKilometers(50))
  }
}
