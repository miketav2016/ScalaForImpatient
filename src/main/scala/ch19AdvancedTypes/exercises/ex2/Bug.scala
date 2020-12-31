package ch19AdvancedTypes.exercises.ex2

import ch19AdvancedTypes.exercises.ex1.Bug

object Show
object Then
object Around

trait BugFluent {
  this: Bug =>//Such a trait can only be mixed into a subclass of the given type

  def and(obj: Show.type): this.type = this.show()

  def and(obj: Then.type): this.type = this

  def turn(obj: Around.type): this.type = this.turn()
}
