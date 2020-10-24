package chapter2

import java.time.LocalDate

object Exercises extends App {
  //1
  def signum(i: Int): Int = {
    i match {
      case _ if i > 0 => 1
      case _ if i == 0 => 0
      case _ if i < 0 => -1
    }
  }

  println(signum(10))
  //2
  val emptyVal: Unit = {}

  def emptyBlock(): Unit = {}

  //3
  var x: Unit = {}
  var y: Int = 0
  x = y = 1
  println(x , y)
  //4
  for( i <- 10 to 1 by -1) println(i)
  //5
  def countdown(n: Int): Unit = {  for(i <- n to 1 by -1) println(i)}
  //6
  def loopFor(str: String): Long = {
    var res = 1L
    for(i <- 0 until str.length) {
      res *= i.toLong
    }
    res
  }
  println( loopFor("Hello"))
  //7
  def makeUnicode(str: String): Long = {
    str.foldLeft(1L)(_ * _)
  }
  println( makeUnicode("Hello"))
  //8
  def product(s : String): Long = {
    makeUnicode(s: String)
  }
  //9
  def loopUnicode(str: String): Long = {
    if (str.isEmpty) {
      1L
    } else {
      str.head.toLong * loopUnicode(str.tail)
    }
  }
  println( loopUnicode("Hello"))
  //10
  def myPow(x: Double, n: Int): Double = {
    n match {
      case _ if n > 0 && (n % 2 == 0) => myPow(x, n / 2) * myPow(x, n / 2)
      case _ if n > 0 && (n % 2 == 1) => x * myPow(x, n - 1)
      case _ if n < 0 => 1 / myPow(x, - n)
      case _ => 1
    }
  }
  println( myPow(2 , 10))
  println( myPow(2 , -10))
  //11
  implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
    def date(args: Any*): LocalDate = {
      if (args.length != 3) throw new Exception(" Must be only 3 args")
      val(year, month, day) = (args(0).toString.toInt,args(1).toString.toInt, args(2).toString.toInt)
      LocalDate.of(year, month, day)
    }
  }
  val year = 2020
  val month = 11
  val day = 24

  println(date"$year-$month-$day")
}
