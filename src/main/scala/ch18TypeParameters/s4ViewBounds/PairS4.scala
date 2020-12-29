package ch18TypeParameters.s4ViewBounds

// A solution is to use a “view bound”
class PairS4[T <% Comparable[T]](val first: T, val second: T) {
  def smaller: T = if (first.compareTo(second) < 0) first else second
}
