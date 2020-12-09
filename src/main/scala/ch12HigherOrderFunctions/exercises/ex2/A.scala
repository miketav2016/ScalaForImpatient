package ch12HigherOrderFunctions.exercises.ex2

import scala.util.Random

object A extends App {
  val myArray = Array.fill(15)(Random.nextInt / 10000)
  val res = myArray.reduceLeft(math.max(_, _))
  println(myArray.mkString(" "))
  println(res)
}
