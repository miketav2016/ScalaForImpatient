package ch16XMLProcessing.exercises.ex1

import scala.xml.Node

object Answer extends App {
  val items1: Node = <fred1/> (0) // node with one elem
  val items2: Node = <fred2/> (0)(0) // node with one elem
  val items3: Seq[Node] = <fred1/> (0) ++ <fred2/> (0)(0)

  println(items1)
  println(items2)
  println(items3)

}
