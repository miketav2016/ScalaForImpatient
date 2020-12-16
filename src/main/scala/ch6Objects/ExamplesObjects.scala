package ch6Objects

import ch6Objects.ExamplesObjects.CompanionObjects.Account.newUniqueNumber

object ExamplesObjects extends App {

  object Singleton {
    object Accounts {
      private var lastNumber = 0
      def newUniqueNumber(): Int = {
        lastNumber += 1; lastNumber
      }
    }
  }

  object CompanionObjects {

    /*
    * The class and its companion object can access each other’s private features.
    * They must be located in the same source file.
    */
    class Account {
      val id: Int = Account.newUniqueNumber() //attention
      val iD: Int = newUniqueNumber() //attention
      private var balance = 0.0
      def deposit(amount: Double) {
        balance += amount
      }
    }

    object Account { // The companion object
      private var lastNumber = 0

      private def newUniqueNumber(): Int = {
        lastNumber += 1; lastNumber
      }
    }
  }
  val acc = new CompanionObjects.Account
  println(acc.id)
  println(acc.iD)
  object  ObjectsExtendingAClassOrTrait {
    abstract class UndoableAction(val description: String) {
      def undo(): Unit
      def redo(): Unit
    }

    object DoNothingAction extends UndoableAction("Do nothing") {
      override def undo() {}
      override def redo() {}
    }
  }
  val actions = Map(
    "open" -> ObjectsExtendingAClassOrTrait.DoNothingAction,
    "save" -> ObjectsExtendingAClassOrTrait.DoNothingAction
  )// Open and save not yet implemented
 object TheApplyMethod {

    class Account private (val id: Int, initialBalance: Double) {
      private var balance = initialBalance
    }
    object Account { // The companion object
      def apply(initialBalance: Double) = new Account(newUniqueNumber(), initialBalance)
      private var lastNumber = 0
      private def newUniqueNumber(): Int = {
        lastNumber += 1; lastNumber
      }
    }
  }
  val acct0 = TheApplyMethod.Account(1000.0)
//  val acct1 = new TheApplyMethod.Account(10, 1000.0) // fail - primary constructor is private

  object ExeEnumerations {

    object TrafficLightColor extends Enumeration {
      val Red, Yellow, Green = Value
    }
  }
  val exeEnumerationsG = ExamplesObjects.ExeEnumerations.TrafficLightColor.Green
  val exeEnumerationsR = ExamplesObjects.ExeEnumerations.TrafficLightColor.Red
  val exeEnumerationsAll = ExamplesObjects.ExeEnumerations.TrafficLightColor.values
  println(exeEnumerationsG.id)
  println(exeEnumerationsR.id)
  for(i <- exeEnumerationsAll) yield println(i)
}
