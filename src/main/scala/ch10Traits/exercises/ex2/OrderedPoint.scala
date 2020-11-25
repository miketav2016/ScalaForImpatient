package ch10Traits.exercises.ex2
import java.awt.Point

class OrderedPoint(x: Int, y: Int) extends java.awt.Point with scala.math.Ordered[java.awt.Point] {
  override def compare(that: Point): Int = {
    if (this.x < that.x) 10
    else if(this.x == that.x && this.y < that.y) -10
    else if (this.x == that.x && this.y == that.y) 0
    else -20

  }
}
