package ch13Collections.s8MappingAFunction

import scala.collection.mutable.ArrayBuffer

object A extends App {
  val names = List("Peter", "Paul", "Mary")
  for(n <- names) yield n.toUpperCase // alternative
  names.map(_.toUpperCase)
  def ulcase(string: String): Vector[String] = {
    Vector(string.toUpperCase, string.toLowerCase)
  }
  println("Map")
  names.map(ulcase)
  println("flatMap")
  names.flatMap(ulcase)
  names.map(ulcase).flatten

  for(i <- 1 to 10) yield i * i
  (1 to 10).map(i => i * i)
  for(i <- 1 to 10; j <- 1 to 10) yield i * j
  val mult: Seq[Int] = (1 to 10).flatMap(i => 1.to(10).map(i * _))
  val buffer = ArrayBuffer("Peter", "Paul", "Mary")
  println(buffer.mapInPlace(_.toUpperCase))
  println(buffer.map(_.toUpperCase))
  "-3+4".collect { case '+' => 1 ; case '-' => -1 } // Vector(-1, 1)
  val words = Seq("Peter", "Paul", "Mary")
  val map = words.groupBy(_.substring(0, 1).toUpperCase)
  println(map)
}
