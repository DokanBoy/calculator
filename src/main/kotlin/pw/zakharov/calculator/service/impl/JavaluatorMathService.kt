package pw.zakharov.calculator.service.impl

import com.fathzer.soft.javaluator.DoubleEvaluator
import org.springframework.stereotype.Service
import pw.zakharov.calculator.model.User
import pw.zakharov.calculator.service.HistoryService
import pw.zakharov.calculator.service.MathService
import pw.zakharov.calculator.service.UserService

@Service
class JavaluatorMathService(
    private val doubleEvaluator: DoubleEvaluator,
    private val historyService: HistoryService,
    private val userService: UserService
) : MathService {

    @Throws(IllegalArgumentException::class)
    override fun evaluateDouble(expression: String, username: String): Double {
        val user: User = userService.getOrCreate(username)
        try {
            val evaluatedValue = doubleEvaluator.evaluate(expression)
            historyService.saveCalculationHistory(expression, user, null, evaluatedValue)
            return evaluatedValue
        } catch (e: IllegalArgumentException) {
            historyService.saveCalculationHistory(expression, user, e, null)
            throw IllegalArgumentException(e.message, e.cause)
        }
    }

}