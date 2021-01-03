package ch21Implicits.s1ImplicitConversions

object ImplicitConversions extends App {
  val result = 3 * Fraction(4, 5) // Calls int2Fraction(3)
  println(result)
}
