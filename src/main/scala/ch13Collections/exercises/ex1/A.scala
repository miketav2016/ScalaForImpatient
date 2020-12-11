package ch13Collections.exercises.ex1

import scala.collection.SortedSet

object A extends App {

  def indexes(string: String): Map[Char, Set[Int]] = {
    string.zipWithIndex.foldLeft(Map[Char, Set[Int]]())((map, cur) =>
      map + (cur._1 -> (map.getOrElse(cur._1, Set[Int]()) + cur._2)))
  }

  def indexesM0(string: String): Map[Char, SortedSet[Int]] = {
    string.zipWithIndex.foldLeft(Map[Char, SortedSet[Int]]()) {
      case (map, (char, indx)) => map + (char -> (map.getOrElse(char, SortedSet[Int]()) + indx))
    }
  }

  val string = "MississippiMississippiMississippiMississippiMississippi"
  indexes(string).foreach(println)
  indexesM0(string).foreach(println)
}
