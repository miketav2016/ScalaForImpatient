package ch10Traits.s9AbstractFieldsInTraits

import ch10Traits.s7TraitsForRichInterfaces.Logger

trait ShortLogger extends Logger {
  val maxLength: Int // An abstract field
  abstract override def log(msg: String) = {
    super.log(
      if (msg.length <= maxLength) msg
      else s"${msg.substring(0, maxLength - 3)}...")
    // The maxLength field is used in the implementation
  }
}