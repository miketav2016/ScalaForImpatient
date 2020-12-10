package ch13Collections.s1TheMainCollectionsTraits

import java.awt.Color
import scala.collection.immutable.SortedSet
import scala.collection.mutable.ArrayBuffer

object A extends App {
  val coll0 = Seq(1, 2, 3, 4, 5, 6, 7, 8, 9) // ordered, like as Array or List
  val coll1 = Set(1, 2, 3, 4, 5, 6, 7, 8, 9) // unordered
  val iter = coll0.iterator
  while (iter.hasNext)
    print(iter.next() + " ")
  Iterable(0xFF, 0xFF00, 0xFF0000)
  Set(Color.RED, Color.GREEN, Color.BLUE)
  Map(Color.RED -> 0xFF0000, Color.GREEN -> 0xFF00, Color.BLUE -> 0xFF)
  SortedSet("Hello", "World")
  val coll = Seq(1, 1, 2, 3, 5, 8, 13)
  val set = coll.toSet
  val buffer = coll.to(ArrayBuffer)
  Seq(1, 2, 3) == (1 to 3) // true
  Seq(1, 2, 3) == Set(1, 2, 3) // false
}
