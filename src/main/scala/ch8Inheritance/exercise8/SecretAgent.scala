package ch8Inheritance.exercise8

class SecretAgent(codename: String) extends Person(codename) {
  override val name = "secret" // Don't want to reveal name ...
  override val toString = "secret" // ... or class name
}
//1 getter and field
