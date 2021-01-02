package ch20Parsing.s2CombiningParserOperations

object CombiningParserOperations extends App {
  val parser = new ExprParser
  val result = parser.parseAll(parser.expr, "3-4*5")
  if (result.successful) println(result.get)
  /**
   * To interpret this output, you need to know the following:
   * • Literal strings and regular expressions return String values.
   * • p ~ q returns an instance of the ~ case class, which is very similar to a pair.
   * • opt(p) returns an Option, either Some(...) or None.
   * • rep(p) returns a List.
   */
  val result1 = parser.parse(parser.expr, "3-4/5")
  /**
   * There is also a parse method that parses a prefix of a string, stopping when it can’t find
   * another match. That method isn’t very useful; for example,
   * parser.parse(parser.expr, "3-4/5") parses 3-4, then quietly stops at the /
   * which it cannot handle.
   */
  if (result1.successful) println(result1.get)
}
