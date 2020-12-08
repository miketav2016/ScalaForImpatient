package CH12HigherOrderFunctions.s1FunctionsAsValues

import scala.math._

object A extends App {
  val num: Double = 3.14
  val fun: Double => Double = ceil _ // it's mean that now fun wait argument
  println(fun(num))
  println(fun)
  /*The ceil method is a method of the scala.math package object. If you have a method
  from a class, the syntax for turning it into a function is slightly different:*/
  val f: (String, Int) => Char = (_: String).charAt(_: Int)
  val f1: (String, Int) => Char = _.charAt(_) // alternative form
  println(f("hello",3))
  val s1 = Array(3.14, 1.42, 2.0).map(fun)
  println(s1.mkString("Array(", ", ", ")"))
}
