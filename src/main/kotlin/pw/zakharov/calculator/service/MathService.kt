package pw.zakharov.calculator.service

interface MathService {

    fun evaluateDouble(expression: String, username: String): Double

}