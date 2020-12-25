package ch15Annotations.exercises.ex8

object A extends App {
  def allDifferent[T](x: T, y: T, z: T) = x != y && x != z && y != z

  def allDifferentM[@specialized T](x: T, y: T, z: T) = x != y && x != z && y != z

  /*generate methods for primitive type values automatically by annotating the type parameter with
  @specialized*/
}
