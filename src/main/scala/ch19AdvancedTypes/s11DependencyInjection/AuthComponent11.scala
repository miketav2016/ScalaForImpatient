package ch19AdvancedTypes.s11DependencyInjection

trait AuthComponent11 {
    this: LoggerComponent11 => // Gives access to logger
    trait Auth11
    val auth: Auth11
    class MockAuth(file: String) extends Auth11
}
