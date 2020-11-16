package chapter8.exercise9

class SubCreature1 extends Creature {
  override val range: Int = 27
}

object A1 extends App {
  val c = new SubCreature1
//  c.range
  println(c.env.length)
  /**because range not executed*/
}
