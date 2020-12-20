package ch17Futures.s9ExecutionContexts

import java.util.concurrent.Executors
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{ExecutionContext, Future, blocking}
import scala.io.Source

object A extends App {
  val pool1 = Executors.newCachedThreadPool()
  implicit val ec1 = ExecutionContext.fromExecutor(pool1)//Now this pool is used by all futures when ec is in scope.

  val f: Future[String] = Future {
    val url = "http://horstmann.com"
    blocking {
      val contents = Source.fromURL(url)
      val t = contents.mkString
      contents.close()
      t
    }
  }
  f.foreach(println)(ec1)
  f.value
  Thread.sleep(100)

  val pool = Executors.newCachedThreadPool()
  implicit val ec = ExecutionContext.fromExecutor(pool)//Now this pool is used by all futures when ec is in scope.

}
