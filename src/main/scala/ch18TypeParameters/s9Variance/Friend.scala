package ch18TypeParameters.s9Variance
//the type parameter to be contravariant
trait Friend[-T] { //denotes someone who is willing to befriend anyone of type T.
  def befriend(someone: T)
}