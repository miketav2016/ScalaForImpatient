package ch10Traits.s8ConcreteFieldsInTraits

import ch10Traits.s7TraitsForRichInterfaces.Logger

trait ShortLogger extends Logger {
  val maxLength = 15

  abstract override def log(msg: String): Unit = {
    super.log(
      if (msg.length <= maxLength) {
        msg
      } else {
        s"${msg.substring(0, maxLength - 3)}..."
      }
    )
  }
}
