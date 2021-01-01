package ch19AdvancedTypes.exercises.ex10

trait Name {
  self: A =>
  override def toString: String = "Trait" + super.toString

  override val name: String = " trait"+ self.name
}
