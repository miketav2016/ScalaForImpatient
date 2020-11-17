package chapter9.CH2ReadingCharacters

import scala.io.{BufferedSource, Source}

class ReadCharacters {
  val source: BufferedSource = Source.fromFile("src/main/scala/chapter9/theory.txt", "UTF-8")
  /**To read individual characters from a file*/
  for (c <- source) println(c)

  val iter: scala.collection.BufferedIterator[Char] = source.buffered
  while (iter.hasNext) {
    if (iter.headOption.nonEmpty) {
      iter.next
    } else {
      println(0)
    }
  }
  val source0: BufferedSource = Source.fromFile("src/main/scala/chapter9/theory.txt", "UTF-8")
  /**if file isn’t large, you can just read it into a string and process that*/
  val contents: String = source0.mkString(" ", "\n", ")")
  source0.close()
  source.close()
}

object A extends App {
  val readFile = new ReadCharacters
//  println(readFile.contents)
}