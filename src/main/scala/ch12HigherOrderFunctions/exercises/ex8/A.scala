package ch12HigherOrderFunctions.exercises.ex8

object A extends App {
  val a = Array("Hello", "World")
  val b = Array(5, 5)
  println(a.corresponds(b)(_.length == _))
}
