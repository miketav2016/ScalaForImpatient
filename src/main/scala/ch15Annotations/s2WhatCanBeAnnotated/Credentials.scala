package ch15Annotations.s2WhatCanBeAnnotated

case class Inject() extends scala.annotation.Annotation

class Credentials @Inject()(var username: String, var password: String)

