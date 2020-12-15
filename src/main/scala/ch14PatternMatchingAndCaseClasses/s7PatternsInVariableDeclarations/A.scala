package ch14PatternMatchingAndCaseClasses.s7PatternsInVariableDeclarations

import scala.math.E

object A extends App {
  val (x, y) = (1, 2)
  val (q, r) = BigInt(10) /% 3
  val arr = Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
  val arr1 = Array(E, 2)
  val Array(first, second, rest@_*) = arr
  val Array(E, x1) = arr1
  /*In a declaration
val Array(E, x) = arr, E is deemed a constant and x a variable that becomes
arr(1) if arr has length 2 and arr(0) == E.
*/
  println(E)
  println(x1)
}
