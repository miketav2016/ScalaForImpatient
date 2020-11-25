package ch10Traits.exercises.ex2

import java.awt.Point

object A extends App {
  val o = new OrderedPoint(10, 20)

  println(o.compare(new Point(10,10)))
}
