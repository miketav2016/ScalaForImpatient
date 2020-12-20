package ch17Futures.s5ComposingFutureTasks

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.io.StdIn
import scala.math.random
import scala.util.{Failure, Success, Try}

object A extends App {

  def getData1(): Int = {
    if (random() < 0.5) throw new Exception
    100
  }

  def getData2() = 200

  val future1 = Future {
    getData1()
  }
  val future2 = Future {
    getData2()
  }

  val combinedNotConcurrently = future1.map(_ + getData2())
  val combinedConcurrently0: Future[Future[Int]] = future1.map(n1 => future2.map(_ + n1))
  val combinedConcurrently: Future[Int] = future1.flatMap(n1 => future2.map(_ + n1))
  //for
  val combinedConcurrently1: Future[Int] = for {
    n1 <- future1
    n2 <- future2
  } yield n1 + n2
  //You can also apply guards in the for expression
  //If the guard fails, the computation fails with a NoSuchElementException
  for {
    n1 <- future1
    n2 <- future2
    if n1 == n2
  } yield n1 + n2

  future1 onComplete {
    case Success(n1) =>
      future2 onComplete {
        case Success(n2) =>
          val n = n1 + n2
          println(s"Result: $n")
        case Failure(ex) => println("fail future2")
      }
    case Failure(ex) => println("fail future1")
  }
  Thread.sleep(1000)
  println(combinedNotConcurrently.value)
  println(combinedConcurrently.value)

  // Sometimes, you need one task to run after another.
  def getData() = 200

  def getMoreData(int: Int = 0) = 300 + int

  def future11: Future[Int] = Future {
    getData()
  }

  def future22: Future[Int] = Future {
    getMoreData()
  } // def, not val
  val combined2 = for (
    n1 <- future11; //It doesn’t matter whether you use val or def for future1
    n2 <- future22
  ) yield n1 + n2

  //  This is particularly useful if the second step depends on the output of the first:
  def future13 = Future {
    getData()
  }

  def future23(arg: Int) = Future {
    getMoreData(arg)
  }

  val combined3 = for (n1 <- future13; n2 <- future23(n1)) yield n1 + n2

  def readInt(prompt: String) = Try(StdIn.readLine(s"$prompt: ").toInt)
  val t = for (n1 <- readInt("n1"); n2 <- readInt("n2")) yield n1 + n2
//  t.map(println)
  println(t)

}
