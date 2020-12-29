package ch18TypeParameters.s3BoundsForTypeVariables

class PairS3[T <: Comparable[T]](val first: T, val second: T) {//This means that T must be a subtype of Comparable[T]
  /*
  That’s wrong—we don’t know if first has a compareTo method.
  To solve this, we can add an upper bound T <: Comparable[T].
  */
  def smaller:T = if (first.compareTo(second) < 0 ) first else second
}
