package ch16XMLProcessing.exercises.ex4

import java.io.FileInputStream
import scala.xml.{Elem, XML}

object Answer extends App {
  val path: String = "src/main/scala/ch16XMLProcessing/exercises/ex4/test.XML"
  val root: Elem = XML.load(new FileInputStream(path))
  for (n <- root \\ "img" if n.attribute("alt").isEmpty) yield println(n)
}
