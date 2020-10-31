package chapter3

import scala.collection.mutable.ArrayBuffer
import scala.util.Random
import scala.util.Random.nextGaussian

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
  val array1 = ArrayBuffer(1, 2, 3, 4, 5, 6, 7, 8)
  println(array1)
  val newArr = for (i <- 1 to array1.length / 2 * 2 - 1 by 2;
                    j <- i - 1 to i) yield {
    if (i > j && (i - 1) == j) {
      array1(i)
    } else if (i == j) {
      array1(i - 1)
    }
  }
  if (newArr.length != array1.length) {
    println(newArr ++ array1.reverse.take(1))
  }
  println(array1)
  val newArr1 = for (i <- 1 to array1.length + 1 by 2;
                     j <- i to i - 1 by -1 if j < array1.length) yield array1(j)
  println(newArr1)
  //4
  val array4 = ArrayBuffer(1, -2, 0, -3, -4, -5, 6, -7, 8)
  println(array4)
  val p = ArrayBuffer[Int]()
  val n11 = ArrayBuffer[Int]()
  for (i <- array4) yield if (i > 0)
    p += i
  else {
    n11 += i
  }
  println("ex4  v1 " + (p ++ n11))
  println("ex4  v2 " + array4.sortBy(_ <= 0))
  //5
  val dArray = new Array[Double](10)
  for (i <- dArray.indices) yield dArray(i) += (2 * nextGaussian() - 1).round
  val dArrayM = Array.fill(20)(Random.between(0, 10))
  println(dArrayM.mkString("Array(", ", ", ")"))
  println("average " + dArrayM.sum / dArrayM.length)
  //6
  println("Array")
  val array6 = Array.fill(20)(Random.between(0, 10))
  println(array6.mkString("Array(", ", ", ")"))
  println(array6.reverse.mkString("Array(", ", ", ")"))
  println("ArrayBuffer")
  val arrayB6 = ArrayBuffer.fill(20)(Random.between(0, 10))
  println(arrayB6)
  println(arrayB6.reverse)
  //7
  val array7 = Array.fill(20)(Random.between(1, 10))
  println(array7.mkString("Array(", ", ", ")"))
  println(array7.distinct.mkString("Array(", ", ", ")"))
  println(array7.distinct.product)
  //8
  val arrayB8 = ArrayBuffer.fill(10)(Random.between(-10, 10))
  println(arrayB8)
  /*var first = true
  var length = arrayB8.length
  var i = 0
  while (i < length) {
    if (arrayB8(i) >= 0) i += 1
    else {
      if (first) { first = false; i += 1 }
      else { arrayB8.remove(i); length -= 1 }
    }
  }*/
  val indNeg = ArrayBuffer[Int]()
  for (i <- arrayB8.indices) yield if (arrayB8(i) < 0) indNeg += i
  val indNegH = indNeg.tail.reverse
  println(s"index neg elem : ${indNegH.mkString("",", ","")} ")
  val updateAB8 = for (i <- indNegH) yield arrayB8.remove(i)
  println(arrayB8)
  //9
  val arrayB9 = ArrayBuffer.fill(10)(Random.between(-10, 10))
  println(arrayB9)
  val neg = arrayB9.zipWithIndex.filter(_._1 < 0).tail.reverse
  println(neg)
  neg.map { case (_, i) => arrayB9.remove(i) }
  println(arrayB9)
  //10
  val timeZone = java.util.TimeZone.getAvailableIDs.filter(a => a.contains( "America/")).map(_.replace("America/", " "))
  println(timeZone.mkString("Array(", ", ", ")"))
  //11
}
