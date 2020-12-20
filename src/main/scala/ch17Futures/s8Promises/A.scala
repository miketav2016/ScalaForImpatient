package ch17Futures.s8Promises

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}

object A {

  def workHard(arg: String): Int = {
    arg.toInt
  }

  def main(args: Array[String]): Unit = {
    def computeAnswer0(arg: String): Future[Int] = Future {
      val n = workHard(arg)
      n
    }

    def computeAnswer1(arg: String): Future[Int] = {
      val p = Promise[Int]()
      Future {
        val n = workHard(arg)
        p.success(n)
        println(workHard("2431125"))
      }
      p.future
    }

    computeAnswer0("111").foreach(println)
    computeAnswer1("111").foreach(println)

    val p1 = Promise[Int]()
    val p2 = Promise[Int]()
    Future {
      val n1 = 100
      p1.success(n1)
      val n2 = 200
      p2.success(n2)
    }

    val p: Promise[Int] = Promise[Int]()
    Future {
      var n = workHard("1")
      p.trySuccess(n)
    }
    Future {
      var n = workHard("10")
      p.trySuccess(n)
    }
    /*
    The promise is completed by the first task that manages to produce the result.
    With this approach, the tasks might want to periodically call p.isCompleted
    to check whether they should continue.
    */
    Thread.sleep(1000)
    println(p)
    Thread.sleep(1000)
  }
}
