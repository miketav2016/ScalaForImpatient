package ch13Collections.exercises.ex6

object A extends App {
  val lst = List[Int](1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
  val r0: List[Int] = (lst :\ List[Int]())(_ :: _) // foldRight set in  inception
  val r0m: List[Int] = (lst :\ List[Int]())(_ +: _) // foldRight set in  inception
  val r1: List[Int] = (List[Int]() /: lst)(_ :+ _)  //foldLeft  set in end
  println(r0)
  println(r0 == r0m)
  println(r1)
  val rMR: List[Int] = lst.foldRight(List[Int]())((res, i) => i :+ res) // Modify
  val rML: List[Int] = lst.foldLeft(List[Int]())((res, i) => i :: res) // Modify
  println(rMR)
  println(rML)


}
