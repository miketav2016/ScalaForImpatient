package CH12HigherOrderFunctions.s2AnonymousFunctions

object A extends App {
  (x: Double) => 3 * x //Here is an anonymous function
  val triple: Double => Double = (x: Double) => 3 * x

  def triple(x: Double): Double = 3 * x

  Array(3.14, 1.42, 2.0).map((x: Double) => 3 * x) //used
  Array(3.14, 1.42, 2.0).map{ (x: Double) => 3 * x } //alternative
  Array(3.14, 1.42, 2.0) map { (x: Double) => 3 * x } //alternative
}
