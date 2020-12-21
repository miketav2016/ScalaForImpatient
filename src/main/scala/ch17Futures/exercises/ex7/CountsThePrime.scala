package ch17Futures.exercises.ex7

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.math.BigDecimal.int2bigDecimal

object CountsThePrime extends App {
  def countConsistently(n: Int): Seq[Int] = {
    (1 to n).filter(n => n.toBigInt.isProbablePrime(1))
  }

  def countParallel(n: Int, p: Int): Future[Seq[Int]] = {
    val batches: List[Range] = (1 to n).grouped((n + p) / (p)).toList
    //    println(batches)
    Future.traverse(batches)((line: Seq[Int]) =>
      Future {
        //        println("thread" + Thread.currentThread().getId)
        line.filter(n => n.toBigInt.isProbablePrime(1))
      }
    ).map(_.foldLeft(Seq[Int]()) { case (acc, c) => acc ++ c })
  }

  //val n = 100000000
  val n = 10000000
  val p = Runtime.getRuntime.availableProcessors()
  println(s"Available Processors: $p")
  val t0 = System.nanoTime()
  val res = Await.result(countParallel(n, p), scala.concurrent.duration.Duration.Inf)
  val t1 = System.nanoTime()
  val t01 = t1 - t0
  println(t01)
  println(s"Elapsed time parallel    : ${t01 / 1000000000} s ${t01 / math.pow(10, 6).toInt % 1000} ms ${t01 % 1000000} ns")
  val t2 = System.nanoTime()
  countConsistently(n)
  val t3 = System.nanoTime()
  val t32 = t3 - t2
  println(s"Elapsed time Consistently: ${t32 / 1000000000} s ${t32 / math.pow(10, 6).toInt % 1000} ms ${t32 % 1000000} ns")
  //  print(res)
}
