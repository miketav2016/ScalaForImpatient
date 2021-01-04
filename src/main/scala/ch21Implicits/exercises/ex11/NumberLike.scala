package ch21Implicits.exercises.ex11

trait NumberLike[T] {
  def plus(x: T, y: T): T

  def divideBy(x: T, n: Int): T

  def average[T](x: T, y: T)(implicit ev: NumberLike[T]) =
    ev.divideBy(ev.plus(x, y), 2)
}

object NumberLike {

  implicit object NumberLikeDouble extends NumberLike[Double] {
    def plus(x: Double, y: Double) = x + y

    def divideBy(x: Double, n: Int) = x / n
  }

  implicit object NumberLikeBigDecimal extends NumberLike[BigDecimal] {
    def plus(x: BigDecimal, y: BigDecimal) = x + y

    def divideBy(x: BigDecimal, n: Int) = x / n
  }

  implicit object NumberLikeString extends NumberLike[String] {
    def plus(x: String, y: String) = x + y

    def divideBy(x: String, n: Int) = {
      x.grouped(n).foldLeft("")((acc, cur) => acc + cur.head)
    }
  }

}
