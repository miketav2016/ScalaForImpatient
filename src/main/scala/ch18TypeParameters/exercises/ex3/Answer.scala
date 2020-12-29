package ch18TypeParameters.exercises.ex3

import ch18TypeParameters.exercises.ex1.Pair1

object Answer extends App {
  val pair1: Pair1[String, Int] = new Pair1("string", 1000)
  def swap[T, S](p:  Pair1[T, S]): Pair1[S, T] ={
    new Pair1(p.b, p.a)
  }
}
