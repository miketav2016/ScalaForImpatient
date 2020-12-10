package ch13Collections.s10Zipping

object A extends App {
  val prices = List(5.0, 20.0, 9.95)
  val quantities = List(10, 2, 1)
  val pq: List[(Double, Int)] = prices zip quantities
  println(pq)

  def adjustToPair(fun: (Double, Int) => Double): ((Double, Int)) => Double = {
    x: (Double, Int) => fun(x._1, x._2)
  }
  ((prices zip quantities) map { p => p._1 * p._2 }).sum
  val res: List[Double] = pq.map(adjustToPair(_ * _))
  res.sum
  List(5.0, 20.0, 9.95) zip List(10, 2) // List((5.0, 10), (20.0, 2))
  List(5.0, 20.0, 9.95).zipAll(List(10, 2), 0.0, 1) //List((5.0, 10), (20.0, 2), (9.95, 1)
  "Scala".zipWithIndex // Vector(('S', 0), ('c', 1), ('a', 2), ('l', 3), ('a', 4))
  println("Scala".zipWithIndex.max)

}
