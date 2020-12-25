package ch15Annotations.exercises.ex4

import scala.annotation.varargs

object MSum {
  @varargs def sum(n: Int*): Int = n.sum

  sum(1, 2, 3, 4)
}
