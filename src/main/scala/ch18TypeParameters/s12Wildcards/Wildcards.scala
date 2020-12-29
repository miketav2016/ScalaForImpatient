package ch18TypeParameters.s12Wildcards

import ch18TypeParameters.s9Variance.Person

object Wildcards {
  //void makeFriends(List<? extends Person> people) // This is Java
  def process(people: java.util.List[_ <: Person]) = {} // This is Scala

  def makeFriends(p: PairS12[_ <: Person]) = {} // OK to call with a Pair[Student]

  import java.util.Comparator

  def min[T](p: PairS12[T])(comp: Comparator[_ >: T]) = {}

}
