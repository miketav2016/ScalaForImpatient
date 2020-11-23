package ch10Traits.s5LayeredTraits

import ch10Traits.s2TraitsAsInterfaces.ConsoleLogger

trait TimestampLogger extends ConsoleLogger {
  override def log(msg: String) {
    super.log(s"${java.time.Instant.now()} $msg")
  }
}
