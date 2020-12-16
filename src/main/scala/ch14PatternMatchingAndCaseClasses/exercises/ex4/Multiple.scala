package ch14PatternMatchingAndCaseClasses.exercises.ex4

sealed trait Item

case class Multiple(num: Int, item: Item*) extends Item
case class Article(string: String, price: Double) extends Item
