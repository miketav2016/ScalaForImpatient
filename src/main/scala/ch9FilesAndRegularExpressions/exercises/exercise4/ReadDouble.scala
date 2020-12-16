package ch9FilesAndRegularExpressions.exercises.exercise4

import scala.io.{BufferedSource, Source}

object ReadDouble extends App {
  def statistic(path: String): Unit = {
    val source: BufferedSource = Source.fromFile(path, "UTF-8")
    val tokens: Array[String] = source.mkString.split("\\s+")
    val doubles: Array[Double] = tokens.map(_.toDouble)
    println(s"sum = ${doubles.sum}")
    println(s"avr = ${doubles.sum / doubles.length}")
    println(s"max = ${doubles.max}")
    println(s"min = ${doubles.min}")
  }

  val path = "src/main/scala/chapter9/exercises/exercise4/test.txt"
  statistic(path)
}
