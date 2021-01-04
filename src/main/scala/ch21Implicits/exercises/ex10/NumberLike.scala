package ch21Implicits.exercises.ex10

trait NumberLike[T] {
  def plus(x: T*): T

  def divideBy(x: T, n: Int): T

  // an implicit parameter
  def average[T](x: T*)(implicit ev: NumberLike[T]) =

    ev.divideBy(ev.plus(x: _*), x.length)

  /*//a context bound
  def average[T : NumberLike](x: T, y: T) = {
    val ev = implicitly[NumberLike[T]]
    ev.divideBy(ev.plus(x, y), 2)
  }
  */


}

object NumberLike {

  implicit object NumberLikeDouble extends NumberLike[Double] {
    def plus(x: Double*): Double = {
      x.sum
    }

    def divideBy(x: Double, n: Int) = x / n

  }

  implicit object NumberLikeBigDecimal extends NumberLike[BigDecimal] {
    def plus(x: BigDecimal*) = x.sum

    def divideBy(x: BigDecimal, n: Int) = x / n
  }

}

