package ch17Futures.s6OtherFutureTransformations

import java.sql.SQLException
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.math.random

object A extends App {

  def persist(data: Int) = {
    if (random() < 0.5) throw new SQLException
    100 + data
  }

  //The recover method accepts
  // a partial function that can turn an exception into a successful result.
  val f = Future { persist(100) } recover { case e: SQLException => 0 }
  f.map(println)
  //When you call f.fallbackTo(f2), then f2 is executed if f fails
  val f1 = Future { 0 }
  for (ex <- f1.failed)
    println(ex)

  val future1 = Future { 100 }
  val future2 = Future { 200 }
  val combined = future1.zipWith(future2)(_ + _)
  Thread.sleep(1000)
  println(combined)
}
