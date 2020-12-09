package ch12HigherOrderFunctions.exercises.ex4

object A extends App {
  def factorialM(int: Int): Int = {
    (1 to int).foldLeft(1)( _ * _)
  }
  println(factorialM(- 5))
}
