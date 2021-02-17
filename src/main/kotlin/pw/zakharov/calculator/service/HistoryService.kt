package pw.zakharov.calculator.service

import org.springframework.data.domain.Page
import pw.zakharov.calculator.model.CalculationHistory
import pw.zakharov.calculator.model.User
import java.util.*

interface HistoryService {

    fun saveCalculationHistory(
        expression: String,
        user: User,
        evaluateException: Exception?,
        result: Double?
    ): CalculationHistory

    fun findCalculationHistoryBetweenDates(start: Date, end: Date): List<CalculationHistory>

    fun findCalculationHistoryByUsername(username: String): List<CalculationHistory>

    fun findAll(page: Int, size: Int): Page<CalculationHistory>

}