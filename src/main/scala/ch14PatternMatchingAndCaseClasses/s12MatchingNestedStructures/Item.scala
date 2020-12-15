package ch14PatternMatchingAndCaseClasses.s12MatchingNestedStructures

abstract class Item
case class Article(description: String, price: Double) extends Item
case class Bundle(description: String, discount: Double, items: Item*) extends Item
