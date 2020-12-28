package ch16XMLProcessing.exercises.ex8

import scala.xml.{Elem, Node}

object Answer extends App {
  val map: Map[String, String] = Map("A" -> "1", "B" -> "2")
  val xml: Elem = <dl><dt>A</dt><dd>1</dd><dt>B</dt><dd>2</dd></dl>

  def foo0(map: Map[String, String]): Elem = {
    <dl>{for ((k, v) <- map) yield <dt>{k}</dt><dd>{v}</dd>}</dl>
  }

  def foo(xml: Elem): Map[String, String] = {
    xml match {
      case <dl>{children@_*}</dl> =>
        val tmp: Iterator[Seq[Node]] = children.grouped(2)
          tmp.foldLeft(Map[String, String]()) { case (acc, Seq(k, v)) => acc + (k.text -> v.text) }
    }
  }

  val res = foo(xml)
  println(res == map)
}
