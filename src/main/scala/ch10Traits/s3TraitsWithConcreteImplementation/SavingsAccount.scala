package ch10Traits.s3TraitsWithConcreteImplementation

import ch10Traits.s2TraitsAsInterfaces.ConsoleLogger
/**we say that the ConsoleLogger functionality is “mixed in”
 * with the SavingsAccount class.*/
class SavingsAccount extends Account with ConsoleLogger{
  def withdraw(amount: Double) {
    if (amount > balance) log("Insufficient funds")
    else balance -= amount
  }
}
/**Note
Supposedly, the “mix in” term comes from the world of ice cream. In the ice cream parlor
parlance, a “mix in” is an additive that is kneaded into a scoop of ice cream before dispensing
it to the customer—a practice that may be delicious or disgusting depending on your point of
view.
*/