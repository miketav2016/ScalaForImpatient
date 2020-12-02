package ch11Operators.exercises.ex3

class Fraction(n: Int, d: Int) {
  private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d);
  private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d);

  override def toString = s"$num/$den"

  def sign(a: Int): Int = if (a > 0) 1 else if (a < 0) -1 else 0

  def gcd(a: Int, b: Int): Int = if (b == 0) scala.math.abs(a) else gcd(b, a % b)

  def +(fraction: Fraction): Fraction = {
    new Fraction((num * fraction.den) + (fraction.num * den), den * fraction.den)
  }

  def -(fraction: Fraction): Fraction = {
    new Fraction((num * fraction.den) - (fraction.num * den), den * fraction.den)
  }

  def *(fraction: Fraction): Fraction = {
    new Fraction(num * fraction.num, den * fraction.den)
  }

  def /(fraction: Fraction): Fraction = {
    this * new Fraction(fraction.den, fraction.num)
  }
}
