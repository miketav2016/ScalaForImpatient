package ch13Collections.s5Sets

object A extends App {
  val set = Set(0, 2, 1, 5, 4, 8, 7, 3)
  val set0 = set + 2
  println(set0)
  val weekdays = scala.collection.mutable.LinkedHashSet("Mo", "Tu", "We", "Th", "Fr")
  val numbers = scala.collection.mutable.SortedSet(1, 2, 3, 4, 5, 0)
  println(weekdays)
  println(numbers)
  println(numbers.subsetOf(set))
  val primes = Set(2, 3, 5, 7)
  println(set union  primes)
  println(set & primes)
  println(set -- primes)

}
