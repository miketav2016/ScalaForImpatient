package ch15Annotations.exercises.ex10

object MyFact extends App {

  def factorial(n: Int): Int = {
    assert(n >= 0)
    n match {
      case i if i > 0 => n * factorial(n - 1)
      case _ => 1
    }
  }
  factorial(+10)
}
