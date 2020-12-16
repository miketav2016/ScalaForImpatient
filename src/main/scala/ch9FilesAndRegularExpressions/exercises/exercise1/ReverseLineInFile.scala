package ch9FilesAndRegularExpressions.exercises.exercise1

import java.io.{File, PrintWriter}

import scala.collection.mutable.ArrayBuffer
import scala.io.{BufferedSource, Source}

object ReverseLineInFile extends App {
  val source: BufferedSource = Source.fromFile("src/main/scala/chapter9/theory.txt", "UTF-8")
  val lineIterator: Iterator[String] = source.getLines
  val stringStore = ArrayBuffer[String]()
  for (l <- lineIterator) stringStore += l
  source.close()
  val path = "src/main/scala/chapter9/exercises/exercise1/result.txt"
  new File(path).delete()
  val out = new PrintWriter(path)
  for (l <- stringStore.reverse) out.println(l)
  out.close()
}
