package ch18TypeParameters.exercises.ex1

class Pair1[T, S](val a:T, val b:S) {
  def swap: Pair1[S, T] = new Pair1(b, a)
}
