package ch18TypeParameters.s8TypeConstraints

// T subtype Comparable[T]
class PairS8[T](val first: T, val second: T)(implicit ev: T <:< Comparable[T]) {
  /*
  In the example above, there is no advantage to using a type constraint over a type bound class
  Pair[T <: Comparable[T]]. However, type constraints are useful in some specialized
  circumstances.
  */
}
