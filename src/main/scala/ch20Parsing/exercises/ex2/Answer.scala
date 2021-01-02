package ch20Parsing.exercises.ex2

object Answer extends App {
  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "4^2^3")
  if (result.successful) println(result.get)
}
