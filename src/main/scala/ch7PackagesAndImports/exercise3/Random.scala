package ch7PackagesAndImports.exercise3
/**Write a package random with functions
 * nextInt(): Int,
 * nextDouble(): Double,
 * setSeed(seed: Int): Unit.
 * To generate random numbers, use the linear congruential generator next = (previous × a + b) mod 2 power n
 * where a = 1664525, b = 1013904223, n = 32, and the initial value of previous is seed.
 */
object Random {
  private val a = 1664525
  private val b = 1013904223
  private val n = 32
  private var _seed = .9
  def nextInt: Int ={
    _seed = nextDouble
    _seed.toInt
  }
  def nextDouble : Double = {
    _seed = (_seed * a + b) % math.pow(2, n)
    _seed
  }
  def setSeed(seed: Int): Unit = {
    _seed = seed
  }
}
object ex3 extends App {
  Random.setSeed(-10)
  println(Random.nextDouble)
  for(_ <- Range(0, 10)) println(Random.nextInt)
}
