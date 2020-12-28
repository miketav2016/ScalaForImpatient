package ch16XMLProcessing.exercises.ex6

import java.io.FileInputStream
import scala.xml.{Elem, Node, XML}

object Answer extends App {

  val path: String = "src/main/scala/ch16XMLProcessing/exercises/ex5/test.XML"
  val root: Elem = XML.load(new FileInputStream(path))
  // TODO:
}
