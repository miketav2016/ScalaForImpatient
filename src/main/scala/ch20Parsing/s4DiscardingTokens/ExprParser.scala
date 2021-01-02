package ch20Parsing.s4DiscardingTokens

import scala.util.matching.Regex
import scala.util.parsing.combinator.RegexParsers

class ExprParser extends RegexParsers {
  val number: Regex = "[0-9]+".r

  def expr: Parser[Int] = term ~ opt(("+" | "-") ~ expr) ^^ {
    case t ~ None => t
    case t ~ Some("+" ~ e) => t + e
    case t ~ Some("-" ~ e) => t - e
  }

  //  def term: Parser[Int] = factor ~ rep("*" ~ factor) ^^ {
  //    case f ~ r => f * r.map(_._2).product
  //  } OLD
  // used ~>
  def term: Parser[Int] = factor ~ rep("*" ~> factor) ^^ {
    case f ~ r => f * r.product
  }

  //Note that the “arrow tip” of the ~> or <~ operator points to the part that is retained.
  def factor: Parser[Int] = number ^^ { _.toInt } | "(" ~> expr <~ ")"


}
