package ch16XMLProcessing.exercises.ex7

import scala.xml.{Elem, NodeBuffer, NodeSeq}

object Answer extends App {
  val map: Map[String, String] = Map("A" -> "1", "B" -> "2")
  val xml: Elem = <dl><dt>A</dt><dd>1</dd><dt>B</dt><dd>2</dd></dl>

  def foo(map: Map[String, String]): Elem = {
    <dl>{for ((k, v) <- map) yield <dt>{k}</dt><dd>{v}</dd>}</dl>
  }
  val res = foo(map)
  println(res == xml)
}
