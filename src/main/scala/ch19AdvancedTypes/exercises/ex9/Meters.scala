package ch19AdvancedTypes.exercises.ex9

class Meters(v: Double) extends Dim[Meters](v, "m") {
  override def create(v: Double) = new Meters(v)
}