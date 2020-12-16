package ch8Inheritance.exercise2

import ch8Inheritance.exercise1.BankAccount

class SavingsAccount(initialBalance: Double, percent: Double) extends BankAccount(initialBalance) {
  private var numOperation = 3

  def earnMonthlyInterest(): Unit = {
    numOperation = 3
    deposit(currentBalance + currentBalance * percent)
  }

  override def deposit(amount: Double): Double = {
    super.deposit(if (numOperation > 0) {
      numOperation -= 1
      amount
    } else {
      println("operations limit exceeded")
      .0
    })
  }

  override def withdraw(amount: Double): Double = {
    super.withdraw(if (numOperation > 0) {
      numOperation -= 1
      amount
    } else {
      println("operations limit exceeded")
      .0
    })
  }
}
