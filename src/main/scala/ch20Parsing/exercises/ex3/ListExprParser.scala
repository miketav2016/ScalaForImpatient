package ch20Parsing.exercises.ex3

import scala.util.matching.Regex
import scala.util.parsing.combinator.RegexParsers

class ListExprParser extends RegexParsers {
  val number: Regex = "-?[0-9]+".r

  def parser(string: String): List[Int] = {
    val res = parseAll(list, string)
    if (!res.successful) {
      throw new IllegalArgumentException("Parsing failed: " + res)
    }
    res.get
  }

  def list: Parser[List[Int]] = "(" ~> repsep(number ^^ { _.toInt }, ",") <~ ")"

}

