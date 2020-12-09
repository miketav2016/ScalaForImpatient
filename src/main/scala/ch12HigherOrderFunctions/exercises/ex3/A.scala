package ch12HigherOrderFunctions.exercises.ex3

object A extends App {
  def factorialM(int: Int): Int = {
    (1 to int).reduceLeft(_ * _)
  }
  println(factorialM(5))
}
