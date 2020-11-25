package ch10Traits.s13SelfTypes

import ch10Traits.s2TraitsAsInterfaces.ConsoleLogger

/**
 * The trait can be mixed into any class that has a getMessage method.
 */
trait LoggedException0 extends ConsoleLogger {
  this: {def getMessage(): String} =>
  def log(): Unit = {
    log(getMessage())
  }
}
