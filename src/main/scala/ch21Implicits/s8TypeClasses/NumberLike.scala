package ch21Implicits.s8TypeClasses

trait NumberLike[T] {
  def plus(x: T, y: T): T

  def divideBy(x: T, n: Int): T

  // an implicit parameter
  def average[T](x: T, y: T)(implicit ev: NumberLike[T]) =
    ev.divideBy(ev.plus(x, y), 2)

  /*//a context bound
  def average[T : NumberLike](x: T, y: T) = {
    val ev = implicitly[NumberLike[T]]
    ev.divideBy(ev.plus(x, y), 2)
  }
  */


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

}
