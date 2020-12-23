package ch15Annotations.s3AnnotationArguments

import ch15Annotations.s2WhatCanBeAnnotated.Credentials
import com.sun.tools.doclint.Entity

object AnnotationArguments extends App {
  @Named("creds") var credentials: Credentials = _

  // The value argument is "creds"
  //If the annotation has no arguments, the parentheses can be omitted:
  @Named("") class Credentials
  println(credentials)
}

case class Named(str: String) extends scala.annotation.Annotation
