package chapter3

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object ExercisesWorkingWithArrays extends App {
  //1
  val n: Int = 17
  val a = Array.fill(15)(Random.between(0, n))
  println(a.mkString("Array(", ", ", ")"))
  //2
  val array0 = ArrayBuffer(1, 2, 3, 4, 5)

  def swapPair(i: Int, array: ArrayBuffer[Int]) = {
    array.insert(i, array(i + 1))
    array.remove(i + 2)
  }

  for (i <- 0 to {
    if (array0.length % 2 == 0) {
      array0.length - 1
    } else {
      array0.length - 2
    }
  } by 2) {
    swapPair(i, array0)
  }
  println(array0)
  //3
  val array1 = ArrayBuffer(1, 2, 3, 4, 5, 6, 7)
  println(array1)
  val newArr = for (i <- 1 to array1.length / 2 * 2 - 1 by 2;
                                         j <- i - 1 to i) yield {
    if (i > j && (i - 1) == j) {
      println(s"$i $j = ${array1(i)}")
      array1(i)
    } else if (i == j) {
      println(s"$i $j = ${array1(i - 1)}")
      array1(i - 1)
    }
  }
  if (newArr.length != array1.length ) {
    println( newArr ++ array1.reverse.take(1))
  }
  println(array1)
  val newArr1 = for (i <- 1 until  array1.length + 1 by 2 ;
                     j <- i to i-1 by -1 if j < array1.length)
    yield  array1(j)

  println(newArr1)
  //4
  //5
  //6
  //7
  //8
  //9
  //10
  //11
}
