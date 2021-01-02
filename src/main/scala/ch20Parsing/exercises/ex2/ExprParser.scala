package ch20Parsing.exercises.ex2

import scala.util.matching.Regex
import scala.util.parsing.combinator.RegexParsers

class ExprParser extends RegexParsers {
  val number: Regex = "[0-9]+".r
  def expr: Parser[Int] = term ~ rep(("+" | "-") ~ term ^^ {
    case "+" ~ t => t
    case "-" ~ t => -t
  }) ^^ {
    case t ~ r => t + r.sum
  }

  def term: Parser[Int] = power ~ rep(("*" | "/" | "%") ~ power) ^^ {
    case f ~ r => r.foldLeft(f)((b,a) => a._1 match {
      case "*" => b * a._2
      case "/" => b / a._2
      case "%" => b % a._2
    })
  }
  def power: Parser[Int] = rep(factor ~ "^") ~ factor ^^ {
    case f ~ r => f.foldRight(r)((a,b) => a._2 match {
      case "^" => math.pow(a._1, b).toInt
    })
  }

  def factor: Parser[Int] = number ^^ {
    _.toInt
  } | "(" ~> expr <~ ")"


}
