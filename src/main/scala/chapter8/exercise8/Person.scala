package chapter8.exercise8

class Person(val name: String) {
  override def toString = s"${getClass.getName}[name=$name]"
}
//1 getter and field
