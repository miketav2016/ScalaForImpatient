package ch21Implicits.s8TypeClasses

class Point(val x: Double, val y: Double) {
}
object Point {
  def apply(x: Double, y: Double) = new Point(x, y)
  //Here we added the implicit object to the companion object of Point. If you can’t modify the Point
  //class, you can put the implicit object elsewhere and import it as needed.
  implicit object NumberLikePoint extends NumberLike[Point] {
    def plus(p: Point, q: Point) = Point(p.x + q.x, p.y + q.y)
    def divideBy(p: Point, n: Int) = Point(p.x * 1.0 / n, p.y * 1.0 / n)
  }
}
