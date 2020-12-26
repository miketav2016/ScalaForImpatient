package ch16XMLProcessing.s4EmbeddedExpressions

import scala.xml.NodeBuffer

object EmbeddedExpressions {

  val items = new NodeBuffer
  items += <li>Fred</li>
  items += <li>Wilma</li>
  items += <!-- ... -->
  //It’s Scala inside XML inside Scala inside XML.
  val tmp = <ul>{for (i <- items) yield <li>{i}</li>}</ul>

}
