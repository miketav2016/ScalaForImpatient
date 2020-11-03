package chapter5

import java.time.Instant

object ClassesExamples extends App {
  //1
  val myCounter = new Counter
  myCounter.increment
  println(myCounter.current)
  //2
  val fred = new Person
  println(fred.age)
  println(fred.age)
  fred.age = 30
  fred.age = 21
  println(fred.age) // 30

}

//1. Simple Classes and Parameterless Methods
class Counter {
  private var value = 0

  def increment(): Unit = value += 1

  def current: Int = value
}

//.2 Properties with Getters and Setters
class Person {
  private var privateAge = 0
  private[this] var name = "same name"

  def age = privateAge

  def age_=(newValue: Int) {
    if (newValue > privateAge) privateAge = newValue; // Can't get younger
  }
}

//3Properties with Only Getters
/*1. var foo: Scala synthesizes a getter and a setter.
* 2. val foo: Scala synthesizes a getter
*/
class Message {
  val timeMessage: Instant = java.time.Instant.now()
}
//4. Object-Private Fields
class Counter4 {
  private var value = 0
  private[this] var valueMod = 0

  def increment(): Unit = value += 1
  def current: Int = value
  // Can access private field of other object
  def isLess(other : Counter4) = value < other.value
  // Accessing someObject.value is not allowed
//  def isLessM(other : Counter4) = value < other.valueMod
}
//5. Bean Properties
import scala.beans.BeanProperty
class Person5 {
  @BeanProperty var name: String = _
  /*generates four methods:
1. name: String
2. name_=(newValue: String): Unit
3. getName(): String
4. setName(newValue: String): Unit
*/
}
class Person51(@BeanProperty var name: String)
