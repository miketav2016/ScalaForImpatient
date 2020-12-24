package ch15Annotations.s6AnnotationsForOptimizations

import scala.annotation.tailrec

class Util {
  /*
  Now the program fails with an error message "could not optimize @tailrec
  annotated method sum2: it is neither private nor final so can be
  overridden". In this situation, you can move the method into an object, or you can declare it as
  private or final.
*/
  @tailrec
  final def sumT(xs: Seq[Int], acc: BigInt = 0): BigInt = {
    if (xs.nonEmpty) sumT(xs.tail, acc + xs.head) else acc
  }
}
