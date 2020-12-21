package ch17Futures.exercises.ex4

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object ParallelTwoFoo extends App {
  def doTogether0[T, U, V](f: T => Future[U], g: U => Future[V]): T => Future[(U, V)] = {
    x: T => {
      val fu = f(x)
      val gv = fu.flatMap(g)
      fu.flatMap(u => gv.flatMap(v => Future(u, v)))
    }
  }

  def doTogether1[T, U, V](f: T => Future[U], g: T => Future[V]): T => Future[(U, V)] = {
    x: T => {
      val fu = f(x)
      val gv = g(x)
      val t: Future[(U, V)] = fu.flatMap(u => gv.flatMap(v => Future(u, v))) // alternative, equal
      val t0: Future[Future[(U, V)]] = fu.map(u => gv.flatMap(v => Future(u, v)))
      val t1: Future[Future[(U, V)]] = fu.flatMap(u => gv.map(v => Future(u, v)))
      val t2: Future[Future[Future[(U, V)]]] = fu.map(u => gv.map(v => Future(u, v)))
      for {
        u <- fu
        v <- gv
      } yield (u, v)
    }
  }
}
