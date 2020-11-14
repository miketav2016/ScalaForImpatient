package chapter8

import java.lang.Thread.sleep
import java.nio.charset.Charset
import java.nio.file.{Files, Path}
import java.util.{Calendar, Date}

import chapter5.Person

object Examples extends App {
  val o = new B(1, 2)
  println(o.b, o.b0)
  println((new C).time)
  sleep(1000)
  val myT = new D
  println(myT.time)
  sleep(1000)
  println(myT.time)

  /** 7 Anonymous Subclasses
   * In Scala you might use anonymous subclasses in this case, if:
   * Your client requires you to extend a given interface
   * You register for multiple events at a time (for example a java.awt.MouseListener) */
  val alien: Person = new Person() {
    def greeting = "Greetings, Earthling! My name is Fred."
  }
  /**9 customize an abstract field by using an anonymous type:*/
  val fred = new Person {
    val id = 1729
    var name = "Fred"
  }
  val lunch =  MilTime(1230)
  println(lunch.hours) // OK
//  println(lunch * 2) // Error


}

/** 1 Extending a Class
 * declare a class final so that it cannot be extended */
class A(a: Int) {
  def foo: Int = 1
}

/** 5 Superclass Construction */
class PathWriter(p: Path, cs: Charset) extends
  java.io.PrintWriter(Files.newBufferedWriter(p, cs))

class B(val b: Int, val b0: Int) extends A(b0) {
  /** 2 Overriding Methods */
  override def foo: Int = super.foo + 2

  /** 3 Type Checks and Casts */
  if (foo.isInstanceOf[Int])
    println(2.asInstanceOf[Double])
  else
    println("B")
  if (foo.getClass == classOf[Int]) // better
    println("A")
  else
    println("B")
  /** 4 Protected Fields and Methods */
  protected val str0 = "a protected member is not visible throughout the package to which the class belongs"
  //There is also a protected[this] variant that restricts access to the current object
}

/** 6 Overriding Fields
 * A def can only override another def.
 * A val can only override another val or a parameterless def.
 * A var can only override an abstract var
 * !!! if provide a var, all subclasses are stuck with it. */
class C {
  def time: Date = Calendar.getInstance().getTime
}

class D extends C {
  override val time: Date = Calendar.getInstance().getTime
}

class D1(override val time: Date) extends C
/**8 Abstract Classes*/
abstract class MyAbstract {
/**9 Abstract Fields*/
  val n: Double
  var m: Double // never do it
  def id: Int
}
class MMM(name: String) extends MyAbstract {
  override def id: Int = name.hashCode

  /** 9 Abstract Fields */
  override val n: Double = .0
  override var m: Double = .0
}
/**10 Construction Order and Early Definitions*/
class Creature {
  val range: Int = 10
  val env: Array[Int] = new Array[Int](range)
}/**• Declare the val as final. This is safe but not very flexible.
• Declare the val as lazy in the superclass. This is safe but a bit inefficient.
• Use the early definition syntax in the subclass
 -> class Ant extends { override val range = 2 } with Creature.
 */
class Ant extends Creature {
  override val range = 2
}
/** 11 The Scala Inheritance Hierarchy
 * Both AnyVal and AnyRef extend the Any class, the root of the hierarchy.
 * The Any class defines methods isInstanceOf, asInstanceOf.
 * AnyVal does not add any methods. It is just a marker for value types.
 * The AnyRef class adds the monitor methods wait and notify/notifyAll from the Object
 * class. It also provides a synchronized method with a function parameter.
 * The ??? method is declared with return type Nothing*/
/** 12 Object Equality/
 * the eq method of the AnyRef class checks whether two references refer to the same object.
 * The equals method in AnyRef calls eq. When you define equals, remember to define hashCode as well.
 * You can’t override the == method defined in AnyRef
 * In an application program, you don’t generally call eq or equals. Simply use the == operator. For
 * reference types, it calls equals after doing the appropriate check for null operands.*/

/**13 Value Classes*/
class MilTime private(val time: Int) extends AnyVal {
  def minutes = time % 100
  def hours = time / 100
  override def toString = s"$time"
}
object MilTime {
  def apply(t: Int) =
    if (0 <= t && t < 2400 && t % 100 < 60) new MilTime(t)
    else throw new IllegalArgumentException
}
