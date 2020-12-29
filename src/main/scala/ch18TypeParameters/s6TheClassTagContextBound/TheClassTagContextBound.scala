package ch18TypeParameters.s6TheClassTagContextBound

import scala.reflect._

object TheClassTagContextBound {
  def makePair[T: ClassTag](first: T, second: T): Array[T] = {
    val r = new Array[T](2)
    r(0) = first
    r(1) = second
    r
  }
  val p: Array[Int] = makePair(4, 9)

}
