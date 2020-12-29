package ch18TypeParameters.s3BoundsForTypeVariables

class PairS31[T](val first: T, val second: T) {
//  def replaceFirst(newFirst: T) = new PairS3[T](newFirst, second) // not bad, but =>
  def replaceFirst0[R >: T](newFirst: R) = new PairS31[R](newFirst, second) // better
  def replaceFirst1[R >: T](newFirst: R) = new PairS31(newFirst, second) // equal
  def replaceFirst2[R](newFirst: R) = new PairS31(newFirst, second) //the method will compile, but it will return a Pair[Any].
}
