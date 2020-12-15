package ch14PatternMatchingAndCaseClasses.s15SimulatingEnumerations

object A extends App {
  val color: Any = Red
  color match {
    case Red => "stop"
    case Yellow => "hurry up"
    case Green => "go"
  }

}
