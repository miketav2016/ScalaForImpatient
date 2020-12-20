package ch17Futures.s7MethodsInTheFutureObject

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.math.random

object A extends App {
  val parts: Seq[Int] = 1 to 10
  val futures = parts.map(p => Future {
//    if (random() < 0.5) throw new Exception
    p * 10
  })
  val result0 = Future.sequence(futures)
  //The traverse method combines the map and sequence steps.
  val result1 = Future.traverse(parts)(p => Future {
    p * 10
  })
  // Yields a future to the sum of the results of all futures
  val resultSum = Future.reduceLeft(futures)(_ + _)
  //has the result or failure of the first completed element of futures.
  val result4 = Future.firstCompletedOf(futures)

  val result5 = Future.find(futures)(_ > 500)
  // Yields a Future[Option[T]]


  //  Thread.sleep(10)
  println(result0)
  println(result1)
  println(resultSum)
  println(result4)
  println(result5)
}
