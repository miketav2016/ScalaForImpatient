package ch20Parsing.s6AvoidingLeftRecursion

import scala.util.matching.Regex
import scala.util.parsing.combinator.RegexParsers

class ExprParser extends RegexParsers {
  val number: Regex = "[0-9]+".r
  //Then we would get the correct parse tree.
  // But that doesn’t work—this expr function is left-recursive
  //  def expr: Parser[Int] = expr ~ opt(("+" | "-") ~ term) ^^ {

  def expr: Parser[Int] = term ~ rep(("+" | "-") ~ term ^^ {
    case "+" ~ t => t
    case "-" ~ t => -t
  }) ^^ {
    case t ~ r => t + r.sum
  }

  def term: Parser[Int] = factor ~ rep("*" ~> factor) ^^ {
    case f ~ r => f * r.product
  }

  def factor: Parser[Int] = number ^^ {
    _.toInt
  } | "(" ~> expr <~ ")"


}
