package ch20Parsing.s3TransformingParserResults

import scala.util.matching.Regex
import scala.util.parsing.combinator.RegexParsers

class ExprParser extends RegexParsers {
  val number: Regex = "[0-9]+".r

  def expr: Parser[Int] = term ~ opt(("+" | "-") ~ expr) ^^ {
    case t ~ None => t
    case t ~ Some("+" ~ e) => t + e
    case t ~ Some("-" ~ e) => t - e
  }
  def term: Parser[Int] = factor ~ rep("*" ~ factor) ^^ {
    case f ~ r => f * r.map(_._2).product
  }
  //Here, the ^^ operator applies the function { _.toInt } to the result of number.
  def factor: Parser[Int] = number ^^ { _.toInt } | "(" ~ expr ~ ")" ^^ {
    case _ ~ e ~ _ => e
  }


}
