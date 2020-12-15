package ch14PatternMatchingAndCaseClasses.s11InfixNotationInCaseClauses

import ch14PatternMatchingAndCaseClasses.s9CaseClasses.{Currency, Dollar, Nothing}

object A extends App {
  val amt: Any= Dollar(500)
  amt match {
    case a Currency u => println(s"$a $u")
  }
}
