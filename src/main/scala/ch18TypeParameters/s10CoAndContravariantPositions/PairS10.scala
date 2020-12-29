package ch18TypeParameters.s10CoAndContravariantPositions

class PairS10[+T](val first: T, val second: T)  {
  def replaceFirst[R >: T](newFirst: R) = new PairS10[R](newFirst, second)
  /*Now the method is a generic method with another type parameter R. But R is invariant, so it doesn’t
matter that it appears in a contravariant position.*/
}
