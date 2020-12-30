package ch19AdvancedTypes.exercises.ex1

object Answer extends App {
  val bugsy = new Bug
  bugsy.move(4).show().move(6).show().turn().move(5).show()
}
