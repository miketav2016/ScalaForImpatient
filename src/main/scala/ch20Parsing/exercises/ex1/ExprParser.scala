package ch20Parsing.exercises.ex1

import scala.util.matching.Regex
import scala.util.parsing.combinator.RegexParsers

class ExprParser extends RegexParsers {
  val number: Regex = "[0-9]+".r
  //Simply use the ~ operator to join the parts,
  // and use opt and rep instead of ? and *.
  /**
   * To interpret this output, you need to know the following:
   * • Literal strings and regular expressions return String values.
   * • p ~ q returns an instance of the ~ case class, which is very similar to a pair.
   * • opt(p) returns an Option, either Some(...) or None.
   * • rep(p) returns a List.
   */
  def expr: Parser[Any] = term ~ opt(("+" | "-") ~ expr)
//  def term: Parser[Any] = factor ~ rep("*" ~ factor)
  def term: Parser[Any] = factor ~ rep(("*" | "/" | "%" ) ~ factor)
  def factor: Parser[Any] = number | "(" ~ expr ~ ")"

}
