package ch10Traits.s13SelfTypes

import ch10Traits.s2TraitsAsInterfaces.ConsoleLogger

trait LoggedException extends ConsoleLogger {
  this: Exception =>
  def log() = {
    log(getMessage)
  }
/**
 * Note that the trait does not extend the Exception class. Instead, it has a self type of Exception.
 * That means it can only be mixed into subclasses of Exception.
 * */
}
