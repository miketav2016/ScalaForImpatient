package ch14PatternMatchingAndCaseClasses.exercises.ex2

object SwapPair extends App {
  def swapM(pair: (Int, Int)): (Int, Int) = pair match {
    case (i: Int, j: Int) => (j, i)
  }
  val p = (1, 2)
  println(swapM(p))
}
