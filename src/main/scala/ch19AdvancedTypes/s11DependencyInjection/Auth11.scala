package ch19AdvancedTypes.s11DependencyInjection

trait Auth11 {
    this: Logger11 =>
    def login(id: String, password: String): Boolean
}
