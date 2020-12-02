package ch11Operators.exercises.ex4

class Money($: Int, c: Int) {
  private val dollar = $ + c / 100
  private val cent = c % 100
  def + (money: Money): Money = {
    new Money(dollar + money.dollar, cent + money.cent)
  }
  def - (money: Money): Money = {
    new Money(dollar - money.dollar, cent - money.cent)
  }
  def * (i: Int): Money = {
    new Money(dollar * i, cent * i)
  }
  /** work like in bank, you lost money XD*/
  def / (i: Int): Money = {
    val preRes = (dollar * 100 + cent) / i
    new Money(preRes / 100, preRes % 100 )
  }
  def == (money: Money): Boolean = {
    (this.dollar * 100 + this.cent ) == (money.dollar * 100 + money.cent)
  }
  def < (money: Money): Boolean = {
    (this.dollar * 100 + this.cent ) < (money.dollar * 100 + money.cent)
  }

  override def toString: String = s"$dollar.$cent"
}
