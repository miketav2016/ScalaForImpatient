package ch2ControlStructuresAndFunctions

import scala.io.StdIn
import scala.util.Try

object ExamplesStructuresFunctions extends App {

  //  val x: Int = scala.io.StdIn.readInt()
  val x = 10
  val s: Int = if (x > 0) 1 else -1
  val tapeAny: Any = if (x > 0) 1 else () //common supper Type
  println(s"result: $s")
  if (x > 0) 1 else if (x == 0) {
    print("used semicolon");
    0
  } else -1

  val s0, v0, a0 = 10
  val v, a, t = 20
  val spacing =
    s0 + (v - v0) * t
  +.5 * (a - a0) *
    t * t
  println(s"$spacing")
  // loops
  var n = 3
  while (n > 0) {
    println(n)
    n = n - 1
  }
  for (i <- 1 to 5) {
    println(s"update i = $i")
  }
  val str = "Hello"
  var sum = 0
  for (i <- 0 to str.length - 1) {
    //  for (i <- 0 until str.length) {
    sum += str(i)
    println(sum)
  }
  for (ch <- "Hello") {
    sum -= ch; println(sum)
  }
  for (i <- 1 to 5; j <- 1 to 5) print(s" ${i * j} ")
  println()
  for (i <- 1 to 5; j <- 1 to 5 if i != j) print(s" ${i * j} ")
  println()
  for (i <- 1 to 5; from = 5 - i; j <- from to 5) print(s" ${i * j} ")
  println()
  println(for (i <- 1 to 5) yield i % 3)

  for (c <- "Hello"; i <- 0 to 1) yield (c + i).toChar
  // Yields "HIeflmlmop"
  for (i <- 0 to 1; c <- "Hello") yield (c + i).toChar
  // YieldsVector('H', 'e', 'l', 'l', 'o', 'I', 'f', 'm', 'm', 'p')

  //Function
  def abs(arg: Double) = if (arg >= 0) arg else -arg

  def fac(n: Int) = {
    var r = 1
    for (i <- 1 to n) r *= i
    r
  }

  def facRec(n: Int): Int = n match {
    case _ if n < 0 => println("Error negative input"); 0
    case 0 => 1
    case 1 => 1
    case _ => n * facRec(n - 1)
  }

  println(s"Fac 10 = ${fac(10)}")
  println(s"facRec 10 = ${facRec(10)}")
  println(s"facRec -10 = ${facRec(-10)}")

  // this is the procedure(return unit)
  def mySum(args: Int*): Unit = {
    val sum1 = args.foldLeft(0)(_ + _)
    val sum2 = args.sum
    var sum = 0
    for (x <- args) {
      sum += x
    }
    println(s"Result = $sum1   ${(sum1 == sum2) == (sum == sum1)}")
  }

  mySum(10, 23, 3256, 347, 1245, 0)
  mySum(1 to 100: _*) // make range to sequence
  // this is the function(return same)
  def mySumRec(args: Int*): Int = {
    if (args.isEmpty) {
      0
    } else {
      args.head + mySumRec(args.tail: _*)
    }
  }

  println(mySumRec(1 to 1000: _*))

  lazy val noUsed: Int = -1
  lazy val usedInt: Double = math.pow(2, 10) // calculate only when will be called
  def exceptionExample(i: Int): Unit = {
    i match {
      case num if num < 0 => throw new IllegalArgumentException("input is negative")
      case _ => println("Win")
    }
  }

  val result =
    for (a <- Try {StdIn.readLine("a: ").toInt};
         b <- Try {StdIn.readLine("b: ").toInt}
         )
      yield a / b
  //  println(s"div a/b = ${result.get}") // worst
  result.foreach(i => println(s"div a/b = $i")) // better
}
