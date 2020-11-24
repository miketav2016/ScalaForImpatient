package ch10Traits.s8ConcreteFieldsInTraits

import ch10Traits.s2TraitsAsInterfaces.ConsoleLogger
import ch10Traits.s3TraitsWithConcreteImplementation.Account

/**
 * Any such fields become fields of the class.
 */
class SavingsAccount extends Account with ConsoleLogger with ShortLogger {
  var interest = 0.0
  override def log(msg: String): Unit = {
    println(msg)
  }
  def withdraw(amount: Double): Unit = {
    if (amount > balance) {
      log("Insufficient funds")
    } else {
      log("foo")
    }
  }
}
