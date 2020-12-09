package ch12HigherOrderFunctions.exercises.ex1

object A extends App {
  def values(fun: (Int) => Int, low: Int, high: Int): Seq[(Int, Int)] = {
    for(i <- low to high) yield (i, fun(i))
  }
  val res = values(x => x * x, - 5 , 5)
  println(res)
}
