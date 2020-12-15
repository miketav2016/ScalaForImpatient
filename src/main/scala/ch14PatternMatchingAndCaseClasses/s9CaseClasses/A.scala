package ch14PatternMatchingAndCaseClasses.s9CaseClasses

object A extends App {

//  Use () with case class instances, no parentheses with case objects.
  val amt: Any= Dollar(500)
    amt match {
    case Dollar(v) => s"$$$v"
    case Currency(_, u) => s"Oh noes, I got $u"
    case Nothing => ""
  }

}
