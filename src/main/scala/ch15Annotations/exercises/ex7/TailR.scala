package ch15Annotations.exercises.ex7

import scala.annotation.tailrec

class TailR {

  @tailrec // must be removed or be final or private
  final def sum2(xs: Seq[Int], partial: BigInt): BigInt =
    if (xs.isEmpty) partial else sum2(xs.tail, xs.head + partial)
}
