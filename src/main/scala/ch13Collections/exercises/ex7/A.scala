package ch13Collections.exercises.ex7

object A extends App {
  val prices = List(5.0, 20.0, 9.95)
  val quantities = List(10, 2, 1)

  def adjustToPair(fun: (Double, Int) => Double): ((Double, Int)) => Double = {
    x: (Double, Int) => fun(x._1, x._2)
  }

  val res = (prices zip quantities) map { p => p._1 * p._2 }
  val res0 = prices.zip(quantities).map { case (p, q) => p * q }
  val res1 = prices.zip(quantities).map {
    Function.tupled(_ * _)
  }
  val res2 = prices.zip(quantities).map(adjustToPair(_ * _))
  val res3 = prices.lazyZip(quantities).map(_ * _)
  println(res)
}
