package ch20Parsing.exercises.ex3

object Answer extends App {
  val parser = new ListExprParser
  val res: List[Int] = parser.parser("(1, 23, -79)")
  println(res)
}
