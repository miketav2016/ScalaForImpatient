package chapter9.CH10RegularExpressions

import scala.util.matching.Regex

class RegularExpressions {
  val numPattern: Regex = "[0-9]+".r
  /**If the regular expression contains backslashes or quotation marks,
   *  then it is a good idea to use the “raw” string syntax, """...""".*/
  val wsnumwsPattern: Regex = """\s+[0-9]+\s+""".r
  /** or a bit easier to read than "\\s+[0-9]+\\s+".r*/

  for (matchString <- numPattern.findAllIn("99 bottles, 98 bottles"))
    println(matchString)
  val matches: Array[String] = numPattern.findAllIn("99 bottles, 98 bottles").toArray
  // Array("99", "98")
  val firstMatch: Option[String] = wsnumwsPattern.findFirstIn("99 bottles, 98 bottles")
  // Some(" 98 ")
  /**There is no method to test whether a string matches the regex in its entirety,
   * but you can add anchors:*/
  val anchoredPattern: Regex = "^[0-9]+$".r
  if (anchoredPattern.findFirstIn("str").isDefined) ???
  /**Alternatively, use the String.matches method:*/
  if ("str".matches("[0-9]+")) ???

  val s0 = numPattern.replaceFirstIn("99 bottles, 98 bottles", "XX")
  // "XX bottles, 98 bottles"
  val s1 = numPattern.replaceAllIn("99 bottles, 98 bottles", "XX")
  // "XX bottles, XX bottles"
  val s2 = numPattern.replaceSomeIn("99 bottles, 98 bottles",
    m => if (m.matched.toInt % 2 == 0) Some("XX") else None)
  // "99 bottles, XX bottles"

}
object A extends App {
  val regularExpressions = new RegularExpressions
  println(regularExpressions.s0)
  println(regularExpressions.s1)
  println(regularExpressions.s2)

  val varPattern = """\$[0-9]+""".r
  def format(message: String, vars: String*) =
    varPattern.replaceSomeIn(message, m => vars.lift(
      m.matched.tail.toInt))
  format("At $1, there was $2 on $0.", "planet 7", "12:30 pm", "a disturbance of the force")
  // At 12:30 pm, there was a disturbance of the force on planet 7.
  println(format("At $1, there was $2 on $0.", "planet 7", "12:30 pm", "a disturbance of the force"))
}
