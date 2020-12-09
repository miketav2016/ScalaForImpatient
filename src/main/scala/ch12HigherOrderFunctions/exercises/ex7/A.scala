package ch12HigherOrderFunctions.exercises.ex7

object A extends App {
  def adjustToPair(fun: (Int, Int) => Int): ((Int, Int)) => Int = {
    x: (Int, Int) => fun(x._1, x._2)
  }

  val pairs: Seq[(Int, Int)] = (1 to 10) zip (11 to 20)
  val res: Seq[Int] = pairs.map(adjustToPair(_ + _))
  println(res)

}
