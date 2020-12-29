package ch18TypeParameters.s9Variance

class Person(name: String) extends Friend[Person] {
  private var privateAge = 0

  def age: Int = privateAge

  def age_=(newValue: Int) {
    if (newValue > privateAge) privateAge = newValue; // Can't get younger
  }

  override def befriend(someone: Person): Unit = ???
}