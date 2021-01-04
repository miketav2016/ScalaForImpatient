package ch21Implicits.exercises.ex5

object Answer extends App {

//  implicit class RichFraction(fractionL: Fraction) extends Ordered[Fraction] {
//    override def compare(that: Fraction): Int = {
//      (fractionL - that).num
//    }
//  }

  def smaller[T](a: T, b: T)(implicit order: T => Ordered[T]): T = {
    if (order(a) < b) a else b
  }

  import ch21Implicits.exercises.ex5.Rich.RichFraction
  smaller(Fraction(1, 7), Fraction(2, 9))
}
