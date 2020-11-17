package chapter9.CH11RegularExpressionGroups

import scala.util.matching.Regex

class RegularExpressionGroups {
  val numitemPattern: Regex = "([0-9]+) ([a-z]+)".r
  val numitemPatternM: Regex = "([0-9]+) ([a-z]+)".r("num", "item")
  for (m <- numitemPattern.findAllMatchIn("99 bottles, 98 bottles"))
    println(m.group(1)) // Prints 99 and 98
  for (m <- numitemPatternM.findAllMatchIn("99 bottles, 98 bottles"))
    println(m.group(2)) // Prints bottles and bottles
  val numitemPattern(num, item) = "99 bottles"
  for (numitemPattern(num, item) <- numitemPattern.findAllIn("99 bottles, 98 bottles")) println(num + item)
}

object A extends App {
  val regularExpressionGroups = new RegularExpressionGroups
  println(regularExpressionGroups.numitemPattern)

}
