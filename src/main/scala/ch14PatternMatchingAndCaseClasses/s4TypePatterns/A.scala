package ch14PatternMatchingAndCaseClasses.s4TypePatterns

object A extends App {
  val obj : Any = 10
  obj match {
    case x: Int => x
    case s: String => Integer.parseInt(s)
    case _: BigInt => Int.MaxValue
    case _ => 0
  }

}
