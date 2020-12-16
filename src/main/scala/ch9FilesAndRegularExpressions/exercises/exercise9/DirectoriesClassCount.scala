package ch9FilesAndRegularExpressions.exercises.exercise9

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
  //  if we knew about AAA
  //  println(entries.map(path => classRegex.matches(path.getFileName.toString)).filter(_ == true).count())
  entries.close()
  println(collectName.length)

}

