package ch13Collections.s13LazyViews

object A extends App {
  val palindromicSquares = (1 to 1000000).view
    .map(x => x * x)
    .filter(x => x.toString == x.toString.reverse)
  println(palindromicSquares.take(10))
  val  res: String = palindromicSquares.take(10).mkString(",")
  println(res)
  palindromicSquares.take(30).view.slice(10, 20).foreach(println)//.transform(x => 0)
}
