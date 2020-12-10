package ch13Collections.s9ReducingFoldingAndScanning

object A extends App {
  println(List(1, 7, 2, 9).reduceLeft(_ - _)) // ((1 - 7) - 2) - 9
  println(List(1, 7, 2, 9).foldLeft(0)(_ - _))
  println((0 /: List(1, 7, 2, 9)) (_ - _))
  println(List(1, 7, 2, 9).reduceRight(_ - _)) //1 - (7 - (2 - 9))
  println(List(1, 7, 2, 9).foldRight(0)(_ - _))
  println((List(1, 7, 2, 9) :\ 0) (_ - _))

  val freq = scala.collection.mutable.Map[Char, Int]()
  for (c <- "Mississippi")
    freq(c) = freq.getOrElse(c, 0) + 1
  // Now freq is Map('i' -> 4, 'M' -> 1, 's' -> 4, 'p' -> 2)
  "Mississippi".foldLeft(Map[Char, Int]())((res, curr) => res + (curr -> (res.getOrElse(curr, 0) + 1)))
  println((1 to 10).foldLeft(List[Int](0))((res, cur) => (cur + res.head) +: res).reverse)
  //methods combine folding and mapping
  println((1 to 10).scanLeft(0)(_ + _))
}
