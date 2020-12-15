package ch14PatternMatchingAndCaseClasses.s14SealedClasses

sealed abstract class Amount1
case class Dollar(value: Double) extends Amount1
case class Currency(value: Double, unit: String) extends Amount1
