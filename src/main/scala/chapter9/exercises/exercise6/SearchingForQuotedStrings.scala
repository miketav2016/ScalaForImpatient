package chapter9.exercises.exercise6

import scala.io.{BufferedSource, Source}
import scala.util.matching.Regex

object SearchingForQuotedStrings extends App {
  def function(): Unit = {
    val quotedPattern: Regex = """(["]) ([\\\"]) ([\\\\"]) ([a-z]+)""".r

    val source: BufferedSource = Source.fromFile("src/main/scala/chapter9/exercises/exercise6/test.txt", "UTF-8")
    val lineIterator: Array[String] = source.getLines.toArray

    for (s <- lineIterator) {
      """"""".r.findAllIn(s).foreach(println(_))
      """\\\"""".r.findAllIn(s).foreach(println(_))
      """\\\\"""".r.findAllIn(s).foreach(println(_))
    }
    source.close()
  }
  function()
}
