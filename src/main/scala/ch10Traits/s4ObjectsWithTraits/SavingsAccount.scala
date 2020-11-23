package ch10Traits.s4ObjectsWithTraits

import ch10Traits.s2TraitsAsInterfaces.{ConsoleLogger, Logger}
import ch10Traits.s3TraitsWithConcreteImplementation.Account

abstract class SavingsAccount extends Account with Logger {
  def withdraw(amount: Double) {
    if (amount > balance)
      log("Insufficient funds")
    else
      ???
  }
}
object A extends App {
  val acct0 = new SavingsAccount {
    override def log(msg: String): Unit = ???
  }
  val acct = new SavingsAccount with ConsoleLogger
  acct.balance
}