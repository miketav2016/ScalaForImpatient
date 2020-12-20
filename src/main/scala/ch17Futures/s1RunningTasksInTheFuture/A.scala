package ch17Futures.s1RunningTasksInTheFuture

import java.time.LocalTime
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object A {
  def main(args: Array[String]): Unit = {
    Future {
      Thread.sleep(1000)
      println(s"This is the future at ${LocalTime.now}  New thread")
    }
    println(s"This is the present at ${LocalTime.now}")
    Future {
      for (i <- 1 to 100) {
        print("A"); Thread.sleep(10)
      }
    }
    Future {
      for (i <- 1 to 100) {
        print("B"); Thread.sleep(10)
      }
    }
    val f: Future[Int] = Future {
      Thread.sleep(10000)
      42
    }
    val f2 = Future {
      if (LocalTime.now.getHour > 12)
        throw new Exception("too late")
      42
    }
    println(f)
    Thread.sleep(12000)
    println(f)
    println(f2)

    Thread.sleep(2000)
  }
}
