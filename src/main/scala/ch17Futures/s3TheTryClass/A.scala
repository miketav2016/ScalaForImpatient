package ch17Futures.s3TheTryClass

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success, Try}

object A extends App {
  val f = Future {
    Thread.sleep(10)
    42
  }
  Await.result(f, 10.seconds)
  val Some(t) = f.value
  t match {
    case Success(v) => println(s"The answer is $v")
    case Failure(ex) => println(ex.getMessage)
  }

  /*alternative*/
  /*
  if (t.isSuccess) println(s"The answer is ${t.get}")
  if (t.isFailure) println(t.failed.get.getMessage)
   */
  //To construct a Try object, call Try(block) with some block of code. For example,
  val str = "11"
  val result = Try(str.toInt)

}
