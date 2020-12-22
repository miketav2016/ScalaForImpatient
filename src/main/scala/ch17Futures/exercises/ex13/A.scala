package ch17Futures.exercises.ex13

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future, Promise}
import scala.math.BigDecimal.int2bigDecimal
import scala.math.random
import scala.util.Success

object A extends App {
  val n = 1000000
  val r: Seq[BigInt] = 1.toBigInt to n
  val p = Runtime.getRuntime.availableProcessors()
  println(s"Available Processors: $p")

  def isPalindromic(n: BigInt): Boolean = {
    n == n.toString.reverse.toInt.toBigInt
  }

  def countParallel(start: Int, end: Int, p: Int): Future[Int] = {
    val batches: List[Range] = (start to end).grouped((end + p) / p).toList
    val promise: Promise[Int] = Promise[Int]()
    Future.traverse(batches)(m => Future {
      val tmp: Iterator[Int] = m.iterator
      while (!promise.isCompleted && tmp.hasNext) {
        val i = tmp.next()
        val r = scala.util.Random
        if (isPalindromic(i) && i.toBigInt.isProbablePrime(1) && r.nextInt(11) > 9) {
          promise.tryComplete(Success(i))
        }
      }
    })
    promise.future
  }

  val res = Await.result(countParallel(123354, 99999999, p), scala.concurrent.duration.Duration.Inf)
  println(res)
}
