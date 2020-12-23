package ch15Annotations.s2WhatCanBeAnnotated

import scala.beans.BeanProperty

object ExamplesOfAnnotate extends App {
  //    @Entity class Credentials
  //  @Test def testSomeFeature() {}
  @BeanProperty var username = ""
  //  def doSomething(@NotNull message: String) = {}
  //You can apply multiple annotations. The order doesn’t matter.
  @BeanProperty
  @Id var username1 = ""
  val myMap = Map[String, String]()
  val key = ""
  //You can also annotate expressions.
  (myMap.get(key): @unchecked) match {
    case _ => ()
  }
  //You can annotate type parameters.
  class MyContainer[@specialized T]
  //Annotations on an actual type are placed after the type, like this:
  def country: String @Localized = ""
  //Here, the String type is annotated. The method returns a localized string
}

case class Id() extends scala.annotation.Annotation

case class Localized() extends scala.annotation.Annotation
