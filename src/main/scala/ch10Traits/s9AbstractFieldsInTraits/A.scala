package ch10Traits.s9AbstractFieldsInTraits

import ch10Traits.s2TraitsAsInterfaces.ConsoleLogger

object A extends App {
  val acct = new SavingsAccount with ConsoleLogger with ShortLogger {
     override val maxLength = 20
  }
}
