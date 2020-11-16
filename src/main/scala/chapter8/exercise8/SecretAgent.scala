package chapter8.exercise8

class SecretAgent(codename: String) extends Person(codename) {
  override val name = "secret" // Don't want to reveal name ...
  override val toString = "secret" // ... or class name
}
//2 getter and 2 field
