package chapter8.exercise9

class SubCreature extends Creature {
  override def range: Int = 28
}

object A extends App {
  val c = new SubCreature
//  c.range
  println(c.env.length)
}
