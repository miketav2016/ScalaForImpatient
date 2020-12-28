package ch16XMLProcessing.exercises.ex5

import java.io.FileInputStream
import scala.xml.{Elem, Node, XML}

object Answer extends App {

  val path: String = "src/main/scala/ch16XMLProcessing/exercises/ex5/test.XML"
  val root: Elem = XML.load(new FileInputStream(path))
  for (n: Node <- root \\ "img") yield n.attribute("src").map(sNode => sNode.map(node => println(node.mkString.split("/").last)))
}
