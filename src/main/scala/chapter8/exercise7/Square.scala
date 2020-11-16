package chapter8.exercise7

import java.awt.Rectangle

class Square(cornerPoint: (Int, Int) = (0, 0), w: Int = 0) extends java.awt.Rectangle {
  private val rect = new Rectangle(cornerPoint._1, cornerPoint._2, w, w)

  def this(w: Int) = {
    this((0, 0), w)
  }

  override def toString: String = s"Square[x= ${rect.x} ,y=${rect.y},width=${rect.width},height=${rect.width}]"
}


object A extends App {
  val q0 = new Square((1, 1), 3)
  val q1 = new Square(3)
  val q2 = new Square
  println(q0)
  println(q1)
  println(q2)
}
