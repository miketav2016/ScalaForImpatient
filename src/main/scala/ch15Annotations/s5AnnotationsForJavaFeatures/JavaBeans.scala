package ch15Annotations.s5AnnotationsForJavaFeatures

import scala.beans.BeanProperty

object JavaBeans extends App {
  val person = new Person
  person.setName("Neo")
  println(person.getName)

}

class Person {
  @BeanProperty var name : String = _
}