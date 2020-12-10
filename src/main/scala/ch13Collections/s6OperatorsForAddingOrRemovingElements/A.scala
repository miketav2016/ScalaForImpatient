package ch13Collections.s6OperatorsForAddingOrRemovingElements

import scala.collection.mutable.ArrayBuffer

object A extends App {
  val seq: Seq[Int] = Seq(1, 2, 3)
  val map: Map[Int, Int] = Map(1 -> 2, 2 -> 3, 3 -> 4)
  val set: Set[Int] = Set(1, 2, 3, 4, 5, 6, 7, 8, 9)
  val arrayBuffer: ArrayBuffer[Int] = ArrayBuffer(1, 2, 3, 4, 5)
  val iterable: Iterable[Int] = Iterable(1, 2, 3, 4, 5)
  val list: List[Int] = List(1, 2, 3, 4, 5)
  println(seq(2) == 3)
  println(seq :+ 5) // added in end
  println(5 +: seq) // added in start
  println(set + 11)
  println(set - 1)
  println(set -- Set(1, 2))
  println("union " + (set | Set(1, 11)))
  println(set & Set(1, 11))
  println(set &~ Set(1, 11))
  println(33 +=: arrayBuffer)
  println(arrayBuffer ++=: arrayBuffer)
  println(arrayBuffer.remove(2), arrayBuffer)
  println(arrayBuffer --= list, " arrayBuffer --= list")
  println(map - 2)
  println(map - (1, 3))
  println(map -- (1 to 2))
  println(map + (11 -> 12))
  println(map(2) == 3)
  println(iterable ++ iterable)
  println(111 :: list)
  println(list ::: list)
  println(list ++: list)
  /*With an immutable collection, you can use += or :+= with a var, like this:*/
  var numbers = Set(1, 2, 3)
  numbers += 5 // Sets numbers to the immutable set numbers + 5
  println(numbers)
  var numberVector = Vector(1, 2, 3)
  numberVector :+= 5 // += does not work since vectors don't have a + operator
  println(numberVector)
  println(Set(1, 2, 3) - 2)// Yields Set(1, 3)
  println(Set(1, 2, 3).init)
  println(Seq(1, 2, 3).permutations.mkString(" "))

}
