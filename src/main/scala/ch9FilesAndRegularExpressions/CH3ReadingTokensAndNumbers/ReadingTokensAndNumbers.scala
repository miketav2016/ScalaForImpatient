package ch9FilesAndRegularExpressions.CH3ReadingTokensAndNumbers

import scala.io.{BufferedSource, Source}

class ReadingTokensAndNumbers {
  val source: BufferedSource = Source.fromFile("src/main/scala/chapter9/theory.txt", "UTF-8")
  val sourceN: BufferedSource = Source.fromFile("src/main/scala/chapter9/CH3ReadingTokensAndNumbers/test.txt", "UTF-8")
  /**quick-and-dirty way of reading all whitespace-separated tokens in a source*/
  val tokens: Array[String] = source.mkString.split("\\s+")
  val tokensN: Array[String] = sourceN.mkString.split("\\s+")
  val numbers: Array[Double] = for (w <- tokensN) yield w.toDouble
  val numbersBetterWay: Array[Double] = tokensN.map(_.toDouble)
  source.close()
  sourceN.close()
}

object A extends App {
  val readFile = new ReadingTokensAndNumbers
  println(readFile.numbers.mkString("Array(", ",\n ", ")"))
  /**Remember—you can always use the java.util.Scanner class to process a file that
   * contains a mixture of text and numbers.*/
  print("How old are you? ")
  val age: Int = scala.io.StdIn.readInt()
  println(s"You enter age = $age")
  // Or use readDouble or readLong
}