package ch19AdvancedTypes.exercises.ex9

abstract class Dim[T](val value: Double, val name: String) {
  this: T =>// answer this
  protected def create(v: Double): T
  def +(other: Dim[T]) = create(value + other.value)
  override def toString() = s"$value $name"
}