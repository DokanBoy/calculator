package pw.zakharov.calculator.service

import org.springframework.stereotype.Service
import pw.zakharov.calculator.model.CalculationHistory
import pw.zakharov.calculator.model.User
import pw.zakharov.calculator.repository.HistoryRepository
import java.util.*

@Service
class HistoryService(private val historyRepository: HistoryRepository) {

    fun saveCalculationHistory(
        expression: String,
        user: User,
        evaluateException: Exception?,
        result: Double?
    ): CalculationHistory {
        return historyRepository.save(
            CalculationHistory(null, user, expression, evaluateException?.message, result, Date())
        )
    }

    fun findCalculationHistory(start: Date, end: Date): List<CalculationHistory> {
        return historyRepository.findAllByDateBetween(start, end)
    }

}