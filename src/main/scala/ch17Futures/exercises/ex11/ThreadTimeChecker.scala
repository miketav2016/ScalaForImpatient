package ch17Futures.exercises.ex11

import java.util.concurrent.Executors
import scala.concurrent.{ExecutionContext, Future}

object ThreadTimeChecker extends App {
  val pool = Executors.newCachedThreadPool()
  implicit val ec = ExecutionContext.fromExecutor(pool) //Now this pool is used by all futures when ec is in scope.
  def getTime(): Future[Unit] = {
    Future {
      println(s"Thread ${Thread.currentThread().getId}")
      Thread.sleep(10000)
      println(s"Thread ${Thread.currentThread().getId}: ${System.nanoTime()}")
    }
  }

  val p = Runtime.getRuntime.availableProcessors()
  println(s"Available Processors: $p")
  for (i <- 1 to p*10) {
    getTime()
  }
  pool.shutdown()
}
