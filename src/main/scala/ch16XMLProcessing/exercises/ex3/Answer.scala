package ch16XMLProcessing.exercises.ex3

import scala.xml.Text

object Answer extends App {
  /*
    Embedded strings do not get turned into Text nodes but into Atom[String] nodes. That is
    not quite the same—Text is a subclass of Atom[String]. It doesn’t matter when saving a
    document. But if you later do pattern matching on Text nodes, the match will fail. In that case,
    you should insert Text nodes instead of strings:
    <li>{Text("Another item")}</li>
   */
  val Fred = "Scala code"
  val tmp1: String = <li>Fred</li> match {
    case <li>{Text(t)}</li>=> t
  }
  val tmp2: String = <li>{Text{"Fred"}}</li> match {
    case <li>{Text(t)}</li> => t
  }
  println(tmp1)
  println(tmp2)
}
