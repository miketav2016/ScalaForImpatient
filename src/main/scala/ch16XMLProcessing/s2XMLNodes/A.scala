package ch16XMLProcessing.s2XMLNodes

import scala.xml.{Elem, NodeBuffer, NodeSeq}

object A extends App {
  val elem: Elem = <a href="http://scala-lang.org">The <em>Scala</em> language</a>
  for (n <- elem.child) println(n)

  val items = new NodeBuffer
  items += <li>Fred</li>
  items += <li>Wilma</li>
  items += <!-- ... -->
  val nodes: NodeSeq = items
  println(items)
}
