package ch14PatternMatchingAndCaseClasses.exercises.ex9

object A extends App {
  val optList = List(Option(1), Option(1), None, Option(1), Option(1), None, Option(1), Option(1), Option(1))
  def sumM(list: List[Option[Int]]) = {
    list.foldLeft(0)((acc, cur) => acc + cur.getOrElse(0))
  }
    println(sumM(optList))
}
