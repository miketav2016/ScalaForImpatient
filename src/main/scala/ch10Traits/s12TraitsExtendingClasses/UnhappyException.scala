package ch10Traits.s12TraitsExtendingClasses

import java.io.IOException

/**
 * Here UnhappyException extends IOException, which already extends Exception. When
 * mixing in the trait, its superclass is already present, and there is no need to add it.
 * , if our class extends an unrelated class, then it is not possible to mix in the trait. For
 * example, you cannot form the following class:
 * class UnhappyFrame extends JFrame with LoggedException
 * // Error: Unrelated superclasses
 */
class UnhappyException extends IOException with LoggedException {
  override def getMessage() = "arggh!"
}
