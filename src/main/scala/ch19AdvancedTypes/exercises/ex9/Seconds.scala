package ch19AdvancedTypes.exercises.ex9

class Seconds(v: Double) extends Dim[Seconds](v, "s") {
  override def create(v: Double) = new Seconds(v)
}
