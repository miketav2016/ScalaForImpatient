package ch21Implicits.exercises.ex7

//import ch21Implicits.exercises.ex6.MyObject.LexicographicPoint
import ch21Implicits.exercises.ex7.MyObject.LexicographicPoint

import java.awt.Point

object Answer extends App {

//  import ch21Implicits.exercises.ex6.Answer.MyObject.LexicographicPoint
  val pointA = new Point(10, 20)
  val pointB = new Point(10, 20)

  println(pointA > pointB)
  println(pointA == pointB)
  println(pointA < pointB)
}
