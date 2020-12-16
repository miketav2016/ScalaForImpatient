package ch9FilesAndRegularExpressions.CH4ReadingFromURLsAndOtherSources

import scala.io.{BufferedSource, Source}

class ReadingFromURLsAndOtherSources {
  /**When you read from a URL, you need to know the character set in advance, perhaps from an
   * HTTP header. See www.w3.org/International/O-charset for more information.*/
  val source1: BufferedSource = Source.fromURL("http://horstmann.com", "UTF-8")
  val source2: Source = Source.fromString("Hello, World!")
  // Reads from the given string—useful for debugging
  val source3: BufferedSource = Source.stdin
  // Reads from standard input
}

object A extends App {
  val readFile = new ReadingFromURLsAndOtherSources
  println(readFile.source1.mkString)
  println(readFile.source2.mkString)
}