package ch7PackagesAndImports

object ChainedPackageClauses {
}
/**7.3 Chained Package Clauses */
package com.horstmann.impatient {
  // Members of com and com.horstmann are not visible here
  package people {
    class Person
  }

  class Manager {
    val subordinates0 = new collection.mutable.ArrayBuffer[Employee] // now it's work
    val subordinates = new _root_.scala.collection.mutable.ArrayBuffer[Employee]
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


