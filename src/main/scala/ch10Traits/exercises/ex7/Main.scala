package ch10Traits.exercises.ex7

object Main {
  def main(args: Array[String]): Unit = {
    val savingsAccount = new SavingsAccount
    println(savingsAccount.balance)
    //class SavingsAccount inherits conflicting members:
    //  def balance: Double (defined in class Account) and
    //  def balance: Double (defined in trait ConsoleLogger)
    //  (note: this can be resolved by declaring an `override` in class SavingsAccount.);
    // other members with override errors are: balance_=
    //class SavingsAccount extends Account with ConsoleLogger{
  }
}
