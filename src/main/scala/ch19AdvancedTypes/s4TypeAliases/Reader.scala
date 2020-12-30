package ch19AdvancedTypes.s4TypeAliases

abstract class Reader {
  type Contents
  def read(fileName: String): Contents
}
