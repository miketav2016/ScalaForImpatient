package ch10Traits.s7TraitsForRichInterfaces

import ch10Traits.s3TraitsWithConcreteImplementation.Account

abstract class SavingsAccount extends Account with Logger {
  def withdraw(amount: Double) {
    if (amount > balance) {
      severe("Insufficient funds")
    } else {
      info("Log INFO")
    }
  }
}
