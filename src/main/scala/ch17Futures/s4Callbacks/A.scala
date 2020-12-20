package ch17Futures.s4Callbacks

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.math.random
import scala.util.{Failure, Success}

object A extends App {
  val f = Future {
    Thread.sleep(100)
    if (random() < 0.5) throw new Exception
    42
  }
  f.onComplete {
    case Success(v) => println(s"The answer is $v")
    case Failure(ex) => println(ex.getMessage)
  }
    Thread.sleep(1000)
}
