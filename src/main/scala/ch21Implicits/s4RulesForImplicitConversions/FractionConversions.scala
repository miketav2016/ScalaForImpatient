package ch21Implicits.s4RulesForImplicitConversions

import scala.language.implicitConversions

object FractionConversions {
  implicit def fraction2Double(f: Fraction) = f.num * 1.0 / f.den
  implicit def int2Fraction(n: Int) = Fraction(n, 1)

}
