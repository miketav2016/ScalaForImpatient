package ch11Operators

class Fraction(n: Int, d: Int) {
  private val num = n
  private val den = d
  def *(other: Fraction) = new Fraction(num * other.num, den * other.den)
}
object Fraction {
  def apply(n: Int, d: Int): Fraction = new Fraction(n, d)
  def unapply(input: Fraction): Option[(Int, Int)] =
    if (input.den == 0) None else Some((input.num, input.den))
}

