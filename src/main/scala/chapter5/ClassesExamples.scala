package chapter5

import java.io.FileReader
import java.time.Instant
import java.util.Properties

import chapter5.ClassesExamples.{chatter, myFace}

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
  //A class user must then use an auxiliary constructor to construct a Person object.
  //  val p61 = new Person6()
  val p62 = new Person6("Mike")
  val p63 = new Person6("Mike", 28)
  val p71 = new Person7("Mike", 28)
  val mp71 = new MyProg
  val p74 = new Person74("Mike")
  println(p74.description)
  //8
  val chatter: Network = new Network
  val myFace: Network = new Network
  val fred8: chatter.Member = chatter.join("Fred")
  val wilma8: chatter.Member = chatter.join("Wilma")
  fred8.contacts += wilma8 // OK
  val barney: myFace.Member = myFace.join("Barney") // Has type myFace.Member
//  fred8.contacts += barney
  // No—can't add a myFace.Member to a buffer of chatter.Member elements

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
  def isLess(other: Counter4) = value < other.value

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

//6. Auxiliary Constructors
class Person6 private {
  private var name = ""
  private var age = 0

  def this(name: String) {
    this()
    this.name = name
  }

  def this(name: String, age: Int) {
    this(name)
    this.age = age
  }
}

// 7. The Primary Constructor
class Person7(val name: String, val age: Int) {
  println("Just constructed another person")

  def description = s"$name is $age years old"
}

class MyProg {
  private val props = new Properties
  //  props.load(new FileReader("myprog.properties"))
}

class Person71(val name: String = "", val age: Int = 0) //with defaults param
class Person72(val name: String, private var age: Int)

class Person73(name: String, age: Int) {
  def description = s"$name is $age years old"
}

class Person74(val name: String) {
  var age = 0

  def description = s"$name is $age years old"
}

//8 Nested Classes
import scala.collection.mutable.ArrayBuffer
class Network {
  class Member(val name: String) {
    val contacts = new ArrayBuffer[Member]
  }
  private val members = new ArrayBuffer[Member]
  def join(name: String): Member = {
    val m = new Member(name)
    members += m
    m
  }
}
/*
* object Network {
class Member(val name: String) {
val contacts = new ArrayBuffer[Member]
}
}
class Network {
private val members = new ArrayBuffer[Network.Member]
...
}*/
