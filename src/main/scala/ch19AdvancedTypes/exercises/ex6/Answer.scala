package ch19AdvancedTypes.exercises.ex6

object Answer extends App {
  def mySortArrayInt(arraySorted: Array[Int], n: Int): Either[Int, Int] = {
    for (i <- 0 to arraySorted.length - 1) {
      if (arraySorted(i) == n)
        return Left(i)
      else if (arraySorted(i) > n)
        return Right(i)
    }
    Right(arraySorted.length - 1)
  }

  def mySortArrayIntMOD(arraySorted: Array[Int], n: Int): Int Either Int = {
    for (i <- 0 to arraySorted.length - 1) {
      if (arraySorted(i) == n)
        return Left(i)
      else if (arraySorted(i) > n)
        return Right(i)
    }
    Right(arraySorted.length - 1)
  }
}
