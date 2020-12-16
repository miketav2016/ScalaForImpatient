package ch9FilesAndRegularExpressions.exercises.exercise2

import java.io.{File, PrintWriter}

import scala.collection.mutable.ArrayBuffer
import scala.io.{BufferedSource, Source}
import scala.util.matching.Regex

object ReplaceTabs extends App {
  def replace(path: String, n: Int): Unit = {
    val tabPattern: Regex = "\t".r
    val source: BufferedSource = Source.fromFile(path, "UTF-8")
    val lineIterator: Iterator[String] = source.getLines
    val stringStore: ArrayBuffer[String] = ArrayBuffer[String]()
    for (l <- lineIterator) stringStore += tabPattern.replaceAllIn(l, " " * n)
    source.close()
    val path2 = "src/main/scala/chapter9/exercises/exercise2/test1.txt"
    new File(path2).delete()
    val out = new PrintWriter(path2)
    for (l <- stringStore) out.println(l)
    out.close()
  }

  val path = "src/main/scala/chapter9/exercises/exercise2/test.txt"
  replace(path, 10)
}
