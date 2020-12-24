package ch15Annotations.s6AnnotationsForOptimizations

import scala.annotation.tailrec
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration.Inf
import scala.concurrent.{Await, Future}

object TailRecursion extends App {

  //common recursion
  def sum(xs: Seq[Int]): BigInt = {
    if (xs.nonEmpty) xs.head + sum(xs.tail) else 0
  }

  def sumFuture(seq: Seq[Int] => BigInt): Seq[Int] => Future[BigInt] = {
    x: Seq[Int] =>
      Future {
        seq(x)
      }
  }

  //tail recursion
  @tailrec
  def sumT(xs: Seq[Int], acc: BigInt = 0): BigInt = {
    if (xs.nonEmpty) sumT(xs.tail, acc + xs.head) else acc
  }

  def sumFutureT(seq: (Seq[Int], BigInt) => BigInt): Seq[Int] => Future[BigInt] = {
    x: Seq[Int] =>
      Future {
        seq(x, 0)
      }
  }

  val seq: Seq[Int] = 1 to 4900
  val res: Future[BigInt] = sumFuture(sum)(seq)
  val res1: Future[(BigInt, BigInt)] = for {
    common <- sumFuture(sum)(seq)
    tail <- sumFutureT(sumT)(seq)
  } yield (common, tail)
  Await.result(res1, Inf)

  println(new Util().sumT(1 to 1000000))
  res1.map(println)
  println("trampolining")
  import scala.util.control.TailCalls._
  def evenLength(xs: Seq[Int]): TailRec[Boolean] =
    if (xs.isEmpty) done(true) else tailcall(oddLength(xs.tail))
  def oddLength(xs: Seq[Int]): TailRec[Boolean] =
    if (xs.isEmpty) done(false) else tailcall(evenLength(xs.tail))
  val tmp = evenLength(1 to 9990).result
  Thread.sleep(1000)
  println(tmp)
}
