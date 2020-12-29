package ch18TypeParameters.exercises.ex9

class NastyDoublePair(a: Double, b: Double) extends Pair9[Double](a, b) {
  //  override def replaceFirst0[R >: Double](newFirst: R) = new Pair9(math.sqrt(newFirst), b)
  override def replaceFirst[R >: Double](newFirst: R) = new Pair9(math.sqrt(a), b)

}
