package ch14PatternMatchingAndCaseClasses.s9CaseClasses

abstract class Amount
case class Dollar(value: Double) extends Amount
case class Currency(value: Double, unit: String) extends Amount
case object Nothing extends Amount