package ch17Futures.exercises.ex6

import scala.annotation.tailrec
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.io.StdIn.readLine

object A extends App {

  def getPass: Int = {
    readLine().toInt
  }

  def checkPass(pass: Int): Boolean = {
    pass > 100
  }

  //run in current Thread
  @tailrec
  def repeat[T](action: => T, until: T => Boolean): Future[T] = {
    val res = action
    if (until(res))
      repeat(action, until)
    else
      Future(res)
  }


  //run in next Thread
  def repeatM[T](action: => T, until: T => Boolean): Future[T] = {
    @tailrec
    def rec(): T = {
      val res = action
      if (until(res))
        rec()
      else
        res
    }

    Future {
      rec()
    }
  }

  val tmp: Future[Int] = repeatM(getPass, checkPass)
  tmp.onComplete(println)

  Thread.sleep(100000)
}
