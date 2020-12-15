package ch14PatternMatchingAndCaseClasses.s10TheCopyMethodAndNamedParameters

import ch14PatternMatchingAndCaseClasses.s9CaseClasses.Currency

object A extends App {
  val amt = Currency(29.95, "EUR")
  val price0 = amt.copy()
  val price1 = amt.copy(value = 19.95) // Currency(19.95, "EUR")
  val price2 = amt.copy(unit = "CHF") // Currency(29.95, "CHF")

}
