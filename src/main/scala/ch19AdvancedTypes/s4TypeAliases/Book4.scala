package ch19AdvancedTypes.s4TypeAliases

import scala.collection.mutable

class Book4 {
  type Index = mutable.HashMap[String, (Int, Int)]
  val map = new Index()
}
