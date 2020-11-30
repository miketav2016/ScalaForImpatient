package ch10Traits.exercises.ex8

class TestClass extends TestTraitA with TestTraitB with TestTrait {
  override val absVal: Int = 999
}
