package chapter7

import java.awt.Color._
/**7.9 Renaming and Hiding Members*/
import java.util.{HashMap => JavaHashMap} // => rename
import scala.collection.mutable._
/**This is only useful if you import others*/
import java.util.{HashMap => _, _} // => hide
import scala.collection.mutable._
/** Now HashMap unambiguously refers to scala.collection.mutable.
 * HashMap since java.util. HashMap is hidden.*/

/**7.10 Implicit Imports
Every Scala program implicitly starts with*/
import java.lang._
import scala._
import Predef._

object ExamplesPackagesAndImports {
  def main(args: Array[String]): Unit = {
    people.defaultName // access to const
    /**7.7 Imports*/
    val c1 = RED // Color.RED
    val c2 = decode("#ff0000") // Color.decode
    /**7.8 Imports Can Be Anywhere!!!!!!!!!!*/
    import scala.collection.mutable._
    val subordinates = new ArrayBuffer[com.horstmann.impatient.Employee]

  }
}
/**7.1 Packages*/
package com {
  package horstmann {
    package collection {
    }
    /**7.2 Scope Rules*/
    package impatient {
      class Manager {
//        val subordinates = new collection.mutable.ArrayBuffer[Employee] //  doesn’t find it
        val subordinates = new _root_.scala.collection.mutable.ArrayBuffer[Employee] //  but
      }
      class Employee {
        var salary = .0
        def giveRaise(rate: scala.Double) {
          salary += Utils.percentOf(salary, rate)
        }
      }
    }

    object Utils {
      def percentOf(value: Double, rate: Double) = value * rate / 100
    }
  }
}
package net {
  package bigjava {
    class Counter
  }
}

/**7.4 Top-of-File Notation
 *

package com.horstmann.impatient
package people
class Person
 equivalent to
package com.horstmann.impatient {
  package people {
    class Person
    // Until the end of the file
  }
}
 */

/**7.5 Package Objects*/
package object people {
  val defaultName = "John Q. Public"
}
package people {
  class Person {
    var name: String = defaultName // A constant from the package
    /**7.6 Package Visibility*/
    /**The following method is visible in its own package*/
    private[people] def description0 = s"A person with name $name"
    /**You can extend the visibility to an enclosing package*/
    private[impatient] def description1 = s"A person with name $name"

  }
}


