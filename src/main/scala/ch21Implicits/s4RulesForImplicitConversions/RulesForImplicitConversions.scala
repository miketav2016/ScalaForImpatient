package ch21Implicits.s4RulesForImplicitConversions

import ch21Implicits.s4RulesForImplicitConversions.FractionConversions.int2Fraction

object RulesForImplicitConversions {
  3 * Fraction(4, 5) // Calls fraction2Double
  3.den // Calls int2Fraction
  Fraction(4, 5) * 3// Calls int2Fraction
}
