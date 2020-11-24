package ch10Traits.s6OverridingAbstractMethodsInTraits

import ch10Traits.s2TraitsAsInterfaces.Logger

trait TimestampLogger extends Logger {
  abstract override def log(msg: String) {
    super.log(s"${java.time.Instant.now()} $msg")
  }
}
  /**
   * method log in trait Logger is accessed from super.
   * It may not be abstract unless it is overridden by a member declared `abstract`
   * and `override` super.log(s"${java.time.Instant.now()} $msg")
   * but if make abstract override def log it can be work
   * */
