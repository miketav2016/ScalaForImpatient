package ch10Traits.s5LayeredTraits

import ch10Traits.s4ObjectsWithTraits.SavingsAccount

object A extends App {
  val acct1 = new SavingsAccount with TimestampLogger with ShortLogger
  val acct2 = new SavingsAccount with ShortLogger with TimestampLogger
  acct1.log("Sun Feb 06 17:45:45 ICT 2011 Insufficient")
  acct2.log("Sun Feb 06 17:45:45 ICT 2011 Insufficient")
}
/**Note
If you want to control which trait’s method is invoked, you can specify it in brackets:
super[ConsoleLogger].log(...). The specified type must be an immediate
supertype; you can’t access traits or classes that are further away in the inheritance hierarchy.*/