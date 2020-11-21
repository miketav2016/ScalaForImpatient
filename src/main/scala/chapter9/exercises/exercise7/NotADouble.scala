package chapter9.exercises.exercise7

import scala.io.{BufferedSource, Source}

object NotADouble extends App {
  def function(path: String): Unit = {
    val word = """[-+]?[0-9]*\.[0-9]*""".r
    val source: BufferedSource = Source.fromFile(path, "UTF-8")
    val tokens: Array[String] = source.mkString.split("\\s+")
    for (s <- tokens) {
      if(word.findFirstIn(s).isEmpty) println(s)
    }
    source.close()
  }

  val path = "src/main/scala/chapter9/exercises/exercise7/test.txt"
  function(path)
}
