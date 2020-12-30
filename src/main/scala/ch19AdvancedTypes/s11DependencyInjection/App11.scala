package ch19AdvancedTypes.s11DependencyInjection

trait App11 {
    this: Logger11 with Auth11 =>
}
