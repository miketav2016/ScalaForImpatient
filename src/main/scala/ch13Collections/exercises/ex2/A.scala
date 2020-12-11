package ch13Collections.exercises.ex2


object A extends App {

  def indexes(string: String): Map[Char, List[Int]] = {
    string.zipWithIndex.foldLeft(Map[Char, List[Int]]()) {
      case (map, (char, indx)) =>
        map + (char -> (map.getOrElse(char, List[Int]()) :+ indx))
    }
  }

  val string = "MississippiMississippiMississippiMississippiMississippi"
  indexes(string).foreach(println)
}
