package ch15Annotations.s5AnnotationsForJavaFeatures

import java.io.IOException

object MarkerInterfaces {
  val book = new Book
  book.read("")
}

class Person15

@SerialVersionUID(6157032470129070425L)
class Employee extends Person15 with Serializable

class Book {
  @throws(classOf[IOException]) def read(filename: String) {  }
}