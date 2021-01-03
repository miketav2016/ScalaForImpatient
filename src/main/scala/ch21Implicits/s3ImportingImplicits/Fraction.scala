package ch21Implicits.s3ImportingImplicits

class Fraction(n: Int, d: Int) {
  val num = n
  val den = d

  def *(other: Fraction) = new Fraction(num * other.num, den * other.den)

  override def toString: String = {
    if (d == 1)
      n.toString
    else
      s"$n / $d"
  }
}

object Fraction {
  def apply(n: Int, d: Int): Fraction = new Fraction(n, d)

  def unapply(input: Fraction): Option[(Int, Int)] =
    if (input.den == 0) None else Some((input.num, input.den))

}



