package ch15Annotations.s6AnnotationsForOptimizations

object SpecializationForPrimitiveTypes extends App {
  def allDifferent[T](x: T, y: T, z: T) = x != y && x != z && y != z

  def allDifferentM[@specialized T](x: T, y: T, z: T) = x != y && x != z && y != z
  //You can restrict specialization to a subset of types:
  def allDifferentMR[@specialized(Long, Double)  T](x: T, y: T, z: T) = x != y && x != z && y != z

  val tmp0 = allDifferent(3, 4, 5)//each integer is wrapped into a java.lang.Integer before the method is called.
  val tmp1 = allDifferentM(3, 4, 5)
  val tmp2 = allDifferentMR(3, 4, 5)
  println(tmp0)
  println(tmp1)
  println(tmp2)
}
