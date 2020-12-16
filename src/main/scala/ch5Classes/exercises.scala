package ch5Classes

import scala.beans.BeanProperty

object exercises extends App{
  /* Improve the Counter class in Section 5.1,
   “Simple Classes and Parameterless Methods,”
    on page 55 so that it doesn't turn negative at Int.MaxValue.
    */
  object exercises1 {
    class Counter {

      private var value: Long = 0
      def increment(): Unit = value += 1
      def current(): Long = value
    }
  }
  object exercises2 {
    /* Write a class BankAccount with methods deposit and withdraw,
     and a read-only property balance.
     */
    class BankAccount {

      private var balance: Int = 0
      def deposit(money: Int): Unit = balance += money
      def withDraw(money: Int): Unit = balance -= money
      def currentBalance: Int = balance
    }
  }
  object exercise3 {
    /*
    Write a class Time with read-only properties hours and minutes and a method
    before(other: Time): Boolean that checks whether this time comes before the other.
    A Time object should be constructed as new Time(hrs, min), where hrs is in military
    time format (between 0 and 23).
     */
    class Time {

      private var minutes: Int = 0
      private var hours: Int = 0

      def this(hrs: Int, min: Int) {
        this()
        if (hrs >= 0 && hrs <= 23 && min >= 0 && min <= 59) {
          this.hours = hrs
          this.minutes = min
        }
      }

      def before(other: Time): Boolean = {
        ((other.hours - hours) * 60 + (other.minutes - minutes)) > 0
      }
    }

  }

  val time0 = new exercise3.Time(20, 50)
  val time1 = new exercise3.Time(11, 30)
  println(time0.before(time1))

  object exercise4 {
    /*
    * Reimplement the Time class from the preceding exercise so that the internal representation is
    * the number of minutes since midnight (between 0 and 24 × 60 – 1). Do not change the public
    * interface. That is, client code should be unaffected by your change.
    */
    class Time {

      private var minutes: Int = 0

      def this(hrs: Int, min: Int) {
        this()
        if (hrs >= 0 && hrs <= 24 && min >= 0 && min <= 59) {
          this.minutes = hrs * 60 + min
        }
      }

      def before(other: Time): Boolean = {
        (other.minutes - minutes) > 0
      }
    }
  }

  val time40 = new exercise4.Time(20, 50)
  val time41 = new exercise4.Time(21, 30)
  println(time40.before(time41))

  object exercise5 {
    /*Make a class Student with read-write JavaBeans properties name (of type String) and
    id (of type Long). What methods are generated? (Use javap to check.) Can you call the
    JavaBeans getters and setters in Scala? Should you?
    */
    class Student {
      @BeanProperty var name: String = ""
      @BeanProperty var id: Long = 0
    }
  }

  val st0 = new exercise5.Student
  st0.setId(52222)
  st0.setName("testStudent")
  println(st0.getId + " " + st0.getName)

  object exercise6 {
    /* In the Person class of Section 5.1, “Simple Classes and Parameterless Methods,” on page 55,
     * provide a primary constructor that turns negative ages to 0.
     */
    class Person(var age: Int) {
      if (age < 0) age = 0
    }
  }
  object  exercise7 {
    /*Write a class Person with a primary constructor that accepts a string containing a first name,
    * a space, and a last name, such as new Person("Fred Smith"). Supply read-only
    * properties firstName and lastName. Should the primary constructor parameter be a var,
    * a val, or a plain parameter? Why?
    */
    class Person (firstAndLastName: String) {
      private val  res: Array[String] = firstAndLastName.split(" ")
      val  firstName: String = res(0)
      val  lastName: String = res(1)
    }
  }
  val ex7 = new exercise7.Person("Fred Smith")
  println(s"${ex7.firstName}  ${ex7.lastName} ")
  object  exercise8 {
    /*
    * Make a class Car with read-only properties for manufacturer, model name, and model year,
    * and a read-write property for the license plate. Supply four constructors. All require the
    * manufacturer and model name. Optionally, model year and license plate can also be specified in
    * the constructor. If not, the model year is set to -1 and the license plate to the empty string.
    * Which constructor are you choosing as the primary constructor? Why?
    */
    class Car(val manufacturer: String, val modelName: String, val modelYear: Int, val licensePlate: String) {

      def this(manufacturer: String, modelName: String) {
        this(manufacturer, modelName, -1, "")
      }

      def this(manufacturer: String, modelName: String, modelYear: Int) {
        this(manufacturer, modelName, modelYear, "")
      }

      def this(manufacturer: String, modelName: String, licensePlate: String) {
        this(manufacturer, modelName, -1, licensePlate)
      }
    }
  }

  val ex8 = new exercise8.Car("df", "ds", 1999, "888")

  object exercise10 {

    //    class Employee(val name: String, var salary: Double) {
    //      def this() { this("John Q. Public", 0.0) }
    //    }
    class Employee(val name: String = "John Q. Public", var salary: Double = .0) {

    }

  }

}
