package ch19AdvancedTypes.s13FamilyPolymorphism.WithAbstractTypes

object Main {
    import ButtonModule._
    def main(args: Array[String]) {
        val b = new Button
        b.add(new ButtonListener {
            override def occurred(e: ButtonEvent) { println(e) }
        })
        b.click()
    }
}
