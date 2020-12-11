package ch13Collections.exercises.ex3

import scala.collection.mutable.ListBuffer

object A extends App {
  def removeSecond[A](listBuffer: ListBuffer[A]): ListBuffer[A] = {
    val t0 = System.nanoTime()
    val res = listBuffer.foldLeft((ListBuffer[A](), false)) { case ((res, isSecond), curr) =>
      if (isSecond) {
        (res :+ curr, false)
      } else {
        (res, true)
      }
    }._1
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    res
  }

  def removeSecondM0[A](listBuffer: ListBuffer[A]): ListBuffer[A] = {
    val t0 = System.nanoTime()
    for (i <- listBuffer.length - 1 to 0 by -2) listBuffer.remove(i)
    val t1 = System.nanoTime()
    println("Elapsed time M0: " + (t1 - t0) + "ns")
    listBuffer
  }

  def removeSecondM1[A <: Int](listBuffer: ListBuffer[A]): ListBuffer[A] = {
    val t0 = System.nanoTime()
    listBuffer.filter(_ % 2 == 1)
    val t1 = System.nanoTime()
    println("Elapsed time M1: " + (t1 - t0) + "ns")
    listBuffer
  }

  val list: ListBuffer[Int] = ListBuffer(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val res = removeSecond(list)
  println(removeSecondM0(list))
  println(removeSecondM1(list))
  println(res)

}
