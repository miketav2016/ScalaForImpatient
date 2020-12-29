package ch18TypeParameters.s9Variance

object Variance extends App {
  def makeFriends(p: Pair9[Person]) = {

  }
  def makeFriendWith(s: Student, f: Friend[Student]) { f.befriend(s) }

  val susan: Student = new Student("")
  val fred: Person = new Person("")
  /*
  * Note that the type varies in the opposite direction of the subtype relationship. Student is a subtype
  * of Person, but Friend[Student] is a supertype of Friend[Person].
  */
  val res = makeFriendWith(susan, fred)

  def friends(students: Array[Student], find: Function1[Student, Person]): Array[Person] =
  // You can write the second parameter as find: Student => Person
    for (s <- students) yield find(s)
}
