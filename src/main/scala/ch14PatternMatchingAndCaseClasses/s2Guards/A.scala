package ch14PatternMatchingAndCaseClasses.s2Guards

object A extends App {
  var sign = 0
  val ch: Char = '8'
  var digit = 0
  ch match {
    case _ if Character.isDigit(ch) => digit = Character.digit(ch, 10)
    case '+' => sign = 1
    case '-' => sign = -1
    case _ => sign = 0
  }
  println(digit)
}
