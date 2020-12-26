package ch16XMLProcessing.s1XMLLiterals

import scala.xml.NodeBuffer

object Literals extends App {
  //doc a value of type scala.xml.Elem
  val doc: scala.xml.Elem = <html><head><title>Fred's Memoirs</title></head><body>...</body></html>
  //XML literal can be a sequence of nodes.
  val items: NodeBuffer = <li>Fred</li> <li>Wilma</li>
  println(doc)
}
