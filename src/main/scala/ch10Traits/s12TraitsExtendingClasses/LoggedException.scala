package ch10Traits.s12TraitsExtendingClasses

import ch10Traits.s2TraitsAsInterfaces.ConsoleLogger

trait LoggedException extends Exception with ConsoleLogger {
  def log() { log(getMessage) }
}
