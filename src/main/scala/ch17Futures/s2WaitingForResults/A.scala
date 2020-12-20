package ch17Futures.s2WaitingForResults

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}

object A {
  def main(args: Array[String]): Unit = {
    val f = Future {
      Thread.sleep(10000)
      42
    }
    val result = Await.result(f, 10.seconds) // a blocking call that waits for the result.
    //If the task is not ready by the allotted time, the Await.ready method throws a
    //TimeoutException.
    val Some(t) = f.value
    println(t)
  }
}
