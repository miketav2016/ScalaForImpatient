package ch18TypeParameters.exercises.ex8

class Pair8[T](var first: T, var second: T) {
//  def replaceFirst0[R >: T](newFirst: R) { first = newFirst } // Error
  //now T is lower bound for R, need upper
  def replaceFirst1[R <: T](newFirst: R): Unit = { first = newFirst }
  //T is upper bound for R
}
