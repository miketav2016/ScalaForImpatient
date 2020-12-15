package ch14PatternMatchingAndCaseClasses.s5MatchingArraysListsAndTuples

object A extends App {
  val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
  arr match {
    case Array(0) => "0"
    case Array(x, y) => s"$x $y"
    case Array(0, _*) => "0 ..."
    case Array(x, rest@_*) => rest.min
    case _ => "something else"
  }
  val lst = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
  lst match {
    case 0 :: Nil => "0"
    case x :: y :: Nil => s"$x $y"
    case 0 :: tail => "0 ..."
    case _ => "something else"
  }
  val pair = Tuple2(0, 1)
  pair match {
    case (0, _) => "0 ..."
    case (y, 0) => s"$y 0"
    case _ => "neither is 0"
  }


}
