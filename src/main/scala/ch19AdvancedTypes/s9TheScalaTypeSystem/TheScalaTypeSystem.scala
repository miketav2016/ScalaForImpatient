package ch19AdvancedTypes.s9TheScalaTypeSystem

object TheScalaTypeSystem extends App {
    def square(x: Int): Int = x * x
    val triple: Int => Int = (x: Int) => 3 * x
    val tmp: Int => Int = square _

}
