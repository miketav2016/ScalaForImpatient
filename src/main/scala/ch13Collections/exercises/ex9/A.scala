package ch13Collections.exercises.ex9

object A extends App {
  val res0 = for (i <- 1 to 10; j <- 1 to i) yield i * j
  val res03 = for (i <- 1 to 3; j <- 1 to i; k <- 1 to j) yield i * j * k
  val res1 = (1 to 10).flatMap(i => (1 to i).map(j => i * j))
  val res13 = (1 to 3).flatMap(i => (1 to i).flatMap(j => (1 to j).map(k => i * j * k)))
  val res13M = (1 to 3).flatMap(i => (1 to i).map(j => (1 to j).map(k => i * j * k)))
  val res13MM = (1 to 3).map(i => (1 to i).map(j => (1 to j).map(k => i * j * k)))
  println(res13)
  println(res13M)
  println(res13MM)

}
