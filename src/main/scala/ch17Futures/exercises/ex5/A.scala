package ch17Futures.exercises.ex5

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object A extends App {
  def foo[U](f: Future[U]*): Future[Seq[U]] = {
    Future.sequence(f)
  }
}
