package chapter8.exercise11

class Point private(x: Long, y: Long) {
  def this(x: Int, y: Int) = {
    this(x.toLong, y.toLong)
  }
}
object P extends App {
  val p = new Point(10, 50)
  println(p)
}