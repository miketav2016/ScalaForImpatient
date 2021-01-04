package ch21Implicits.exercises.ex1

object Answer extends App {
  val tmp0: (String, Int) = "Hello" -> 42
  val tmp1: (Int, String) = 42 -> "Hello"
  // answer: class Predef.ArrowAssoc is a  implicit and have def ->
}
