package ch20Parsing.s5GeneratingParseTrees

import scala.util.matching.Regex
import scala.util.parsing.combinator.RegexParsers

class ExprParser extends RegexParsers {
  val number: Regex = "[0-9]+".r

  def expr: Parser[Expr] = term ~ opt(("+" | "-") ~ expr) ^^ {
    case t ~ None => t
    case t ~ Some("+" ~ e) => t// + e
    case t ~ Some("-" ~ e) => t// - e
  }

  def term: Parser[Expr] = (factor ~ opt("*" ~> term)) ^^ {
    case a ~ None => a
    case a ~ Some(b) => Operator("*", a, b)
  }
  def factor: Parser[Expr] = number ^^ (n => Number(n.toInt)) |
    "(" ~> expr <~ ")"


}
