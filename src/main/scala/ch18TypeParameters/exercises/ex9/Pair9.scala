package ch18TypeParameters.exercises.ex9

class Pair9[+T](val a: T, val b: T) {
  //def replaceFirst(newFirst: T): Pair9[T] = new Pair9(newFirst, b)
  //now T is lower bound for R
  def replaceFirst[R >: T](newFirst: R): Pair9[R] = new Pair9(newFirst, b)

}
