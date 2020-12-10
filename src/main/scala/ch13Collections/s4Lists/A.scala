package ch13Collections.s4Lists

object A extends App {
  val digit = List(2, 4)
  val head = digit.head
  val tail = digit.tail
  val newList0 = 9 :: List(2, 4)
  val newList1 = 9 :: 2 :: 4 :: Nil
  val newList2 = 9 :: (2 :: (4 :: Nil))

  def mySum(list: List[Int]): Int = {
    if (list.nonEmpty)
      list.head + mySum(list.tail)
    else
      0
  }
  def mySumM1(list: List[Int]): Int = list match {
    case Nil => 0
    case h :: t => h + mySum(t)
  }

  println(mySum(newList0))
  println(mySumM1(newList0))
  println(newList0.sum)
}
