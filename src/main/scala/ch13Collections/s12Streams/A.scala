package ch13Collections.s12Streams

import scala.io.Source

object A extends App {
  def numsFrom(n: BigInt): LazyList[BigInt] = n #:: numsFrom(n + 1) //The tail is unevaluated
  //The #:: operator is like the :: operator for lists, but it constructs a stream.
  val tenOrMore = numsFrom(10)
  println(tenOrMore.head)
  println(tenOrMore.tail.tail.tail.head)
  val squares: LazyList[BigInt] = numsFrom(1).map(x => x * x)
  println(squares.tail.head)
  println(squares.take(10))
  println(squares.take(10).force)
  /*
  * Of course, you don’t want to call
    squares.force // No!
    That call would attempt to evaluate all members of an infinite stream, causing an OutOfMemoryError.
    */

  val words = Source.fromFile(  "src/main/scala/ch13Collections/s12Streams/test.txt").getLines.to(LazyList)

  words // Stream(A, ?)
  words(5) // Aachen
  words // Stream(A, A's, AOL, AOL's, Aachen, ?)

}
