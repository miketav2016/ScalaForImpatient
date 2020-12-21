package ch17Futures.exercises.ex2

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Compose {
  def doInOrder[T, U, V](f: T => Future[U], g: U => Future[V]): T => Future[V] = {
    //    x: T => f(x).map(g(_)).flatten
    x: T => f(x).flatMap(g)
  }
}
