package ch18TypeParameters.s10CoAndContravariantPositions

import ch18TypeParameters.s9Variance.{Person, Student}

object CoAndContravariantPositions extends App {
  /*
  val students = new Array[Student](10)
  val people: Array[Person] = students // Not legal, but suppose it was...
  people(0) = new Person("Fred") // Oh no! Now students(0) isn't a Student


  val people = new Array[Person](10)
  val students: Array[Student] = people // Not legal, but suppose it was...
  people(0) = new Person("Fred") // Oh no! Now students(0) isn't a Student

  */
}
