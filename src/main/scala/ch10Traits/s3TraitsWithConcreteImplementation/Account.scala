package ch10Traits.s3TraitsWithConcreteImplementation

import ch10Traits.s3TraitsWithConcreteImplementation.Account.newUniqueNumber

class Account {
  val id: Int = Account.newUniqueNumber() //attention
  val iD: Int = newUniqueNumber() //attention
  var balance = 0.0

  def deposit(amount: Double) {
    balance += amount
  }
}

object Account { // The companion object
  private var lastNumber = 0

  private def newUniqueNumber(): Int = {
    lastNumber += 1;
    lastNumber
  }
}