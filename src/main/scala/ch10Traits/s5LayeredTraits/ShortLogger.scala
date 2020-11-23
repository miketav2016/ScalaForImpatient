package ch10Traits.s5LayeredTraits

import ch10Traits.s2TraitsAsInterfaces.ConsoleLogger

trait ShortLogger extends ConsoleLogger {
  override def log(msg: String): Unit = super.log(
    if (msg.length <= 15) {
      msg
    } else {
      s"${msg.substring(0, 12)}"
    }
  )
}
