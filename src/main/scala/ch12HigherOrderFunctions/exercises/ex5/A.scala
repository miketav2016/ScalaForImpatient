package ch12HigherOrderFunctions.exercises.ex5

object A extends App {
  def largest(fun: (Int) => Int, inputs: Seq[Int]) = {
    inputs.map(fun).max
  }
  println(largest(x => 10 * x - x * x, 1 to 10 ))
}
