package ch21Implicits.exercises.ex7

import java.awt.Point

object MyObject {

  implicit class LexicographicPoint(self: Point) extends Ordered[Point] {
    //In the Euclidean
    def dist(point: Point): Double = {
      math.sqrt(math.pow(point.x, 2) + math.pow(point.y, 2))
    }

    override def compare(that: Point): Int = {
      dist(self) - dist(that) match {
        case i: Double if i > 0 => 1
        case i: Double if i == 0 => 0
        case i: Double if i < 0 => -1
      }
    }
  }

}