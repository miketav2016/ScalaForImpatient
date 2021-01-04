package ch21Implicits.exercises.ex6

import java.awt.Point

object MyObject {

  implicit class LexicographicPoint(self: Point) extends Ordered[Point] {

    override def compare(that: Point): Int =
      if (self.x == that.x) self.y - that.y
      else self.x - that.x
  }

}