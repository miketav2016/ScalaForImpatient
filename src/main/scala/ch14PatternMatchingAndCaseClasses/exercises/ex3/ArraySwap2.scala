package ch14PatternMatchingAndCaseClasses.exercises.ex3

import scala.reflect.ClassTag

object ArraySwap2 extends App {
  def swapM[T:ClassTag](array: Array[T]): Array[T] = {
    array match {
      case Array(a,b, rest@_*)=>  Array(b, a) ++ rest
      case _ => array
    }
  }

  val array10 =  Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
  val array2 =  Array(1, 2)
  println(swapM(array10).mkString("Array(", ", ", ")"))
  println(swapM(array2).mkString("Array(", ", ", ")"))
  println(swapM(Array()).mkString("Array(", ", ", ")"))
}
