package ch10Traits.s11InitializingTraitFields

import ch10Traits.s10TraitConstructionOrder.{FileLogger, SavingsAccount}

object A extends App{
//  val acct = new SavingsAccount with FileLogger("myapp.log")
  // Error: Can't have constructor parameters for traits
//  val acct0 = new SavingsAccount with FileLogger {
//    val filename = "myapp.log" // Does not work
//  }

  val acct1 = new { // Early definition block after new
    override val filename = "myapp.log"
  } with SavingsAccount with FileLogger

}
