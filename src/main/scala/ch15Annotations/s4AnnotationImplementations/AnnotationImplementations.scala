package ch15Annotations.s4AnnotationImplementations

import ch15Annotations.s2WhatCanBeAnnotated.Id
import com.sun.tools.doclint.Entity

import scala.annotation.meta.{beanGetter, beanSetter, getter, setter}
import scala.annotation.{StaticAnnotation, TypeConstraint}
import scala.beans.BeanProperty

object AnnotationImplementations extends App {

  //Generally, an annotation describes the expression, variable, field, method, class, or type to which it
  //is applied. For example, the annotation
  //the NotNull trait is deprecated
//  def check(@NotNull password: String)
//  applies to the parameter variable password.

  class Credentials(@Localized @BeanProperty var username: String)

}

class unchecked extends annotation.Annotation
class Localized extends StaticAnnotation with TypeConstraint

@getter @setter @beanGetter @beanSetter
class deprecated(message: String = "", since: String = "")
  extends annotation.StaticAnnotation

@Localized class Credentials {
  @(Id @beanGetter) @BeanProperty var id = 0
  //In this situation, the @Id annotation is applied to the Java getId method, which is a JPA
  //requirement for property access.
}