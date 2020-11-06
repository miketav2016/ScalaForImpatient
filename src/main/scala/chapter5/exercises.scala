package chapter5

object exercises {
  /*1. Improve the Counter class in Section 5.1,
   “Simple Classes and Parameterless Methods,”
    on page 55 so that it doesn’t turn negative at Int.MaxValue.
    */
  object exercises1 {
    class Counter {
      private var value: Long = 0
      def increment(): Unit = value += 1
      def current(): Long = value
    }
  }
  object exercises2 {
    /*2. Write a class BankAccount with methods deposit and withdraw,
     and a read-only property balance.
     */
    class BankAccount {
      private var balance: Int = 0
      def deposit(money: Int): Unit = balance += money
      def withDraw(money: Int): Unit = balance -= money
      def currentBalance: Int = balance
    }
  }

}
