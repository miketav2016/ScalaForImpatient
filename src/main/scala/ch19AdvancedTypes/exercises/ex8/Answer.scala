package ch19AdvancedTypes.exercises.ex8

object Answer extends App {
  def printValues(f: Int => Int, from: Int, to: Int) = {
    Range(from, to + 1).foreach(n =>print(s"${f(n)} "))
  }

  printValues((x: Int) => x * x, 3, 6) // Prints 9 16 25 36
  println()
  printValues(Array(1, 1, 2, 3, 5, 8, 13, 21, 34, 55), 3, 6) // Prints 3 5 8 13
}
