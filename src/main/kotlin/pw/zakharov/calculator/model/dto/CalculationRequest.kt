package pw.zakharov.calculator.model.dto

data class CalculationRequest(
    val username: String,
    val expression: String,
)