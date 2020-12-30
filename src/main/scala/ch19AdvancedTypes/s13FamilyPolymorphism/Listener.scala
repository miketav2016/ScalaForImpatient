package ch19AdvancedTypes.s13FamilyPolymorphism

trait Listener[E] {
    def occurred(e: E): Unit
}
