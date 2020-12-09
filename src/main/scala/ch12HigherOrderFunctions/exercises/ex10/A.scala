package ch12HigherOrderFunctions.exercises.ex10

object A extends App {
  def unless(condition: => Boolean)(blockA: => Unit, blockB: => Unit) = {
    if (!condition)
      blockA
    else
      blockB
  }
  unless(10 > 0) (println(10), println(20))
}
