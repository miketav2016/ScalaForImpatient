package ch9FilesAndRegularExpressions.exercises.exercise3

import scala.io.{BufferedSource, Source}
import scala.util.matching.Regex

object Print12CH extends App {
  def p12ch(path: String): Unit = {
    val ch12Pattern: Regex = "[a-zA-Z]{12,}".r
    val source: BufferedSource = Source.fromFile(path, "UTF-8")
    val lineIterator: Iterator[String] = source.getLines
    for (l <- lineIterator) println(ch12Pattern.findAllIn(l).mkString("", " ", ""))
    source.close()
  }

  def OneLine(path: String): Unit = {
    //but need close => Source.fromFile(path, "UTF-8")
    Source.fromFile(path, "UTF-8")
      .getLines
      .foreach(str => println("[a-zA-Z]{12,}".r.findAllIn(str).mkString("", " ", "")))
  }

  def TreeLine(path: String): Unit = {
    val source = Source.fromFile(path, "UTF-8")
    source.getLines
      .foreach(str => println("[a-zA-Z]{12,}".r.findAllIn(str).mkString("", " ", "")))
    source.close()
  }

  val path = "src/main/scala/chapter9/exercises/exercise3/test.txt"
  OneLine(path)
}
