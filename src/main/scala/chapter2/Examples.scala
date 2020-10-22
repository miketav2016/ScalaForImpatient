package chapter2

object Examples extends App {

  //  val x: Int = scala.io.StdIn.readInt()
  val x = 10
  val s: Int = if (x > 0) 1 else -1
  val tapeAny: Any = if (x > 0) 1 else () //common supper Type
  println(s"result: $s")
  if (x > 0) 1 else if (x == 0) {
    print("used semicolon"); 0
  } else -1

  val s0, v0, a0 = 10
  val v, a, t = 20
  val spacing =
    s0 + (v - v0) * t
  +.5 * (a - a0) *
    t * t
  println(s"$spacing")
  // loops
  var n = 3
  while (n > 0) {
    println(n)
    n = n - 1
  }
  for (i <- 1 to 5) {
    println(s"update i = $i")
  }
  val str = "Hello"
  var sum = 0
  for (i <- 0 to str.length - 1) {
//  for (i <- 0 until str.length) {
    sum += str(i)
    println(sum)
  }
  for (ch <- "Hello") {
    sum -= ch; println(sum)
  }
  for (i <- 1 to 5; j <- 1 to 5) print(s" ${i * j} ")
  println()
  for (i <- 1 to 5; j <- 1 to 5 if i != j) print(s" ${i * j} ")
  println()
  for (i <- 1 to 5; from = 5 - i; j <- from to 5) print(s" ${i * j} ")
  println()
  println(for (i <- 1 to 5) yield i % 3)

  for (c <- "Hello"; i <- 0 to 1) yield (c + i).toChar
  // Yields "HIeflmlmop"
  for (i <- 0 to 1; c <- "Hello") yield (c + i).toChar
  // YieldsVector('H', 'e', 'l', 'l', 'o', 'I', 'f', 'm', 'm', 'p')


}
