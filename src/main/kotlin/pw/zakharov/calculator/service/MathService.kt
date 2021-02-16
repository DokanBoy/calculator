package pw.zakharov.calculator.service

import com.fathzer.soft.javaluator.DoubleEvaluator
import org.springframework.stereotype.Service
import pw.zakharov.calculator.model.User

@Service
class MathService(
    private val doubleEvaluator: DoubleEvaluator,
    private val historyService: HistoryService,
    private val userService: UserService
) {

    @Throws(IllegalArgumentException::class)
    fun evaluateDouble(expression: String, username: String): Double {
        val user: User = userService.getOrCreate(username)
        try {
            val evaluatedValue = doubleEvaluator.evaluate(expression)
            historyService.saveCalculationHistory(expression, user, null, evaluatedValue)
            return evaluatedValue
        } catch (e: Exception) {
            historyService.saveCalculationHistory(expression, user, e, null)
            throw IllegalArgumentException(e)
        }
    }

}