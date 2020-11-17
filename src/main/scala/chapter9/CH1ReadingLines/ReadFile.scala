package chapter9.CH1ReadingLines

import scala.io.{BufferedSource, Source}

class ReadFile {
  val source: BufferedSource = Source.fromFile("src/main/scala/chapter9/theory.txt", "UTF-8")
  /** The first argument can be a string or a java.io.File
   * You can omit the encoding if you know that the file uses
   * the default platform encoding */
  val lineIterator: Iterator[String] = source.getLines
  for (l <- lineIterator) l

  val lines: Array[String] = source.getLines.toArray
  val contents: String = source.mkString
  /** Call close when you are done using the Source object. */
  source.close()
}

object A extends App {
  val readFile = new ReadFile
  println(readFile.lines.mkString(" ", "\n", ")"))
}