package ch14PatternMatchingAndCaseClasses.exercises.ex10

import scala.math.sqrt

object A extends App {

  def compose(g: Double => Option[Double], f: Double => Option[Double]): Double => Option[Double] = {
    x => f(x) match {
        case None => None
        case Some(value) => g(value)
      }
  }

  def f(x: Double): Option[Double] = if (x != 1) Some(1 / (x - 1)) else None

  def g(x: Double): Option[Double] = if (x >= 0) Some(sqrt(x)) else None

  val h = compose(g, f) // h(x) should be g(f(x))
  println(h(2))
  println(h(1))
  println(h(0))
}
