package ch15Annotations.s7AnnotationsForErrorsAndWarnings

import scala.annotation.unchecked.uncheckedVariance

object AnnotationsForErrorsAndWarning extends App {
  @deprecated(message = "Use factorial(n: BigInt) instead")
  def factorial(n: Int): Int = {
    n match {
      case i if i > 0 => n * factorial(n - 1)
      case _ => 1
    }
  }

  println(factorial(5))

  def draw(@deprecatedName('sz) size: Int, style: Int = 10) = {}

  //You can still call draw(sz = 12) but you will get a deprecation warning
  draw(sz = 12)

  val lst = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 0)
  (lst: @unchecked) match {
    case head :: tail => println(" Hi")
    /*
    * The compiler won’t complain that there is no Nil option. Of course, if lst is Nil, an exception is
    * thrown at runtime.
    * */
  }

  /*For example, it
  would make sense for java.util.Comparator to be contravariant. If Student is a subtype of
  Person, then a Comparator[Person] can be used when a Comparator[Student] is
  required. However, Java generics have no variance*/
  trait Comparator[-T] extends  java.util.Comparator[T @uncheckedVariance]
}
