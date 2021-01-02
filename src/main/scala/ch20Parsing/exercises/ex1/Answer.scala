package ch20Parsing.exercises.ex1

object Answer extends App {
  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "3-4*5%2")
  if (result.successful) println(result.get)

  val result1 = parser.parse(parser.expr, "3-4/5")
  if (result1.successful) println(result1.get)
}
