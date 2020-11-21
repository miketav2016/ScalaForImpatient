package chapter9.exercises.exercise9

import java.nio.file.{Files, Path, Paths}
import java.util.stream

import scala.collection.mutable.ArrayBuffer
import scala.util.matching.Regex

object DirectoriesClassCount extends App {
  val classRegex: Regex = ".*[/.]class".r
  val dirName: String = ""
  val collectName = ArrayBuffer[String]()
  val entries: stream.Stream[Path] = Files.walk(Paths.get(dirName))
  entries.forEach(p => classRegex.findFirstIn(p.getFileName.toString).foreach(collectName += _))
  entries.close()
  println(collectName.length)

}

