package ch10Traits.s9AbstractFieldsInTraits

import ch10Traits.s2TraitsAsInterfaces.ConsoleLogger
import ch10Traits.s3TraitsWithConcreteImplementation.Account

class SavingsAccount extends Account with ConsoleLogger with ShortLogger {
  override def log(msg: String): Unit = {
    println(msg)
  }
  override val maxLength: Int = 20
}
