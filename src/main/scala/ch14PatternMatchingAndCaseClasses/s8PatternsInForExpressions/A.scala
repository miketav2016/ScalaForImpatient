package ch14PatternMatchingAndCaseClasses.s8PatternsInForExpressions

import scala.jdk.javaapi.CollectionConverters.asScala

object A extends App {
  // Converts Java Properties to a Scala map—just to get an interesting example
  /*for ((k, v) <- System.getProperties())
    println(s"$k -> $v")
   not work
  */
  val props = asScala(System.getProperties)
  for ((k, v) <- props)
    println(s"$k -> $v")
}
