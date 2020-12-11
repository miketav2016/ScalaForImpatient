package ch13Collections.exercises.ex4

object A extends App {
  def myRec(collect: Iterable[String], map: Map[String, Int]): Array[Int] = {
    if (collect.nonEmpty) {
      collect.head
      map.getOrElse(collect.head, 0) +: myRec(collect.tail, map)
    } else {
      Array()
    }
  }

  def myRecM0(collect: Iterable[String], map: Map[String, Int]) = {
    collect.map(key => map.get(key)) // have same and none
    collect.flatMap(key => map.get(key)) // clear
  }

  val coll = Array("Tom", "Fred", "Harry")
  val map = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)
  val res = myRec(coll, map)
  println(res.mkString("Array(", ", ", ")"))
  println(myRecM0(coll, map).mkString("Array(", ", ", ")"))
}
