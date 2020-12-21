package ch17Futures.exercises.ex3

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Compose {
  def doInOrder[T](f: T => Future[T]*): T => Future[T] = {
    f match {
      case fl :: Nil => x: T => fl(x)
      case fh :: _ => x: T => fh(x).flatMap(doInOrder(f: _*))
    }
  }
}
