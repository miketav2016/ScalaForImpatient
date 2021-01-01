package ch19AdvancedTypes.exercises.ex5

import ch19AdvancedTypes.s2TypeProjections.Network

import scala.language.existentials

object Answer extends App {
  type NetworkMember = n.Member forSome {val n: Network}

  def processOld[M <: n.Member forSome { val n: Network }](m1: M, m2: M) = (m1, m2)
  def processNew(m1: NetworkMember, m2: NetworkMember) = (m1, m2)
/*
NetworkMember it's a alias for n.Member forSome {val n: Network} and it's a difference .
 */
}
