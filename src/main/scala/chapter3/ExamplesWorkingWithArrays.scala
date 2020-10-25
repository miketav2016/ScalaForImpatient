package chapter3

import scala.collection.mutable.ArrayBuffer
import scala.util.Random

object ExamplesWorkingWithArrays extends App {
  // Static length
  val nums = new Array[Int](10)
  nums.foreach(n => print( n + " "))
  val a: Array[String] = new Array[String](10)
  val s: Array[String] =  Array("Hello", "World")
  s(0) = "Goodbye"
  println
  // Dynamic length
  val b = ArrayBuffer[Int]()
  val b0 = new ArrayBuffer[Int]()
  b += 1
  b ++= Array (1, 2, 3, 4, 5)
  b ++= Array(8, 5, 4)
  println(b)
  b.trimEnd(5)
  println(b)
  b.insert(2, 6)
  println(b)
  b.remove(2, 1)
  println(b)
  b.toArray.toBuffer
  //Traversing
  for(i <- 0 until a.length) {
//  for(i <- a.indices) {
    println(s"$i : ${a(i)}")
  }
  val range: Seq[Int] = 1 to 10
   for( i <- range){
    println(s"$i : ${range(i - 1)}")
   }
  for( i <- 0 until 10 by 2){
    println(s"$i")
  }
  for( i <- range.indices.reverse){
    println(s"$i")
  }
  for(elem <- range) println(s"$elem")
  //Transform
  val a1 = Array(2, 3, 4, 5, 7, 11)
  //The for/yield loop creates a new collection of the same type as the original collection.
  val result = for (elem <- a1) yield elem * 2
  println(result.mkString("Array(", ", ", ")"))
  val result1 = for (elem <- a1 if elem % 2 == 0 ) yield elem * 2
  println(result1.mkString("Array(", ", ", ")"))
  val myArray = (-10 to 10).toBuffer
  println((for (elem <- myArray if elem >= 0) yield elem).mkString("Array(", ", ", ")"))
  val positionsToRemove = for (i <- myArray.indices if myArray(i) < 0) yield i
  println(positionsToRemove)
  println(positionsToRemove.reverse)
  println(myArray)
  for (i <- positionsToRemove.reverse)  myArray.remove(i)
  println(myArray)
  // Common algorithms
  println(myArray.sum)
  println(myArray.max)
  println(b.sorted)
  println(b.sortWith(_ > _))
  val unsortBuff = ArrayBuffer.fill(15)(Random.nextInt)
  println(unsortBuff)
  val array =  Array(1, 7, 2, 9)
  println(array.mkString("Array(", ", ", ")"))
  scala.util.Sorting.quickSort(array)
  println(array.mkString("Array(", ", ", ")"))
  //Multidimensional Arrays
  val myMatrix = Array.ofDim[Double](3,4)
  myMatrix (2)(1) = 5
  println(myMatrix.foreach(_.mkString(" ", ", ", ")")))

  val triangle = new Array[Array[Int]](10)
  for (i <- triangle.indices)
    triangle(i) = new Array[Int](i + 1)
  println(s.search("1"))
}
