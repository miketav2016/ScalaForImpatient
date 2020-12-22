package ch17Futures.exercises.ex8

import scala.annotation.tailrec
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future, blocking}
import scala.io.{Source, StdIn}

object AskURL extends App {
  //http://horstmann.com
  def askURL: Future[String] = Future {
    println("thread askURL" + Thread.currentThread().getId)
    println("input URL")
    StdIn.readLine()
  }

  def readWeb(url: String): Future[String] = Future {
    println("thread readWeb" + Thread.currentThread().getId)
    val contents = Source.fromURL(url)
    val res = contents.mkString
    contents.close()
    res
  }

  def displays(hyperlinks: String): Future[Unit] = Future {
    println("thread displays" + Thread.currentThread().getId)
    //    println(hyperlinks)
  }

  def tmp1: Future[Unit] = askURL.flatMap(str => readWeb(str).flatMap(displays))

  def tmp2(): Unit = {
    for {
      url <- askURL
      hyperlinks <- readWeb(url)
      _ <- displays(hyperlinks)
    } tmp2()
  }

  tmp2()
  Thread.sleep(20000)
  //  Await.result(tmp1, scala.concurrent.duration.Duration.Inf)
}
