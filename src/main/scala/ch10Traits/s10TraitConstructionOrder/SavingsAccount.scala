package ch10Traits.s10TraitConstructionOrder

import ch10Traits.s3TraitsWithConcreteImplementation.Account
import ch10Traits.s9AbstractFieldsInTraits.ShortLogger
/**The constructors execute in the following order:
 * 1. Account (the superclass).
 * 2. Logger (the parent of the first trait).
 * 3. FileLogger (the first trait).
 * 4. ShortLogger (the second trait). Note that its Logger parent has already been constructed.
 * 5. SavingsAccount (the class).
 * The constructor ordering is the reverse of the linearization of the class. The linearization is a
 * technical specification of all supertypes of a type.
 * It is defined by the rule:If C extends C 1 with C 2 with ... with C n , then lin(C) = C » lin(C n ) » ...
 * » lin(C 2 ) » lin(C 1 )
 */
class SavingsAccount extends Account with FileLogger with ShortLogger{
  override val maxLength: Int = 50
  override val filename: String = ""
}
