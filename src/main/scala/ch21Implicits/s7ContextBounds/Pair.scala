package ch21Implicits.s7ContextBounds

class Pair[T : Ordering](val first: T, val second: T) {
  def smaller(implicit ord: Ordering[T]) =
    if (ord.compare(first, second) < 0) first else second

  def smaller1 =
    if (implicitly[Ordering[T]].compare(first, second) < 0) first else second

}
