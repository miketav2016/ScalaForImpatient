package ch18TypeParameters.s5ContextBounds

//requires that there is an implicit value of type Ordering[T].
class PairS5[T: Ordering](val first: T, val second: T) {
  //When you declare a method that uses the implicit value, you have to add
  //an “implicit parameter.”
  def smaller(implicit ord: Ordering[T]): T = if (ord.compare(first, second) < 0) first else second
}