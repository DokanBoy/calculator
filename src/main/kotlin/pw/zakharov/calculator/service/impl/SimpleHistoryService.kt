package pw.zakharov.calculator.service.impl

import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import pw.zakharov.calculator.model.CalculationHistory
import pw.zakharov.calculator.model.User
import pw.zakharov.calculator.repository.HistoryRepository
import pw.zakharov.calculator.service.HistoryService
import java.util.*

@Service
class SimpleHistoryService(private val historyRepository: HistoryRepository) : HistoryService {

    override fun saveCalculationHistory(
        expression: String,
        user: User,
        evaluateException: Exception?,
        result: Double?
    ): CalculationHistory {
        return historyRepository.save(
            CalculationHistory(null, user, expression, evaluateException?.message, result, Date())
        )
    }

    override fun findCalculationHistoryBetweenDates(start: Date, end: Date): List<CalculationHistory> {
        return historyRepository.findAllByDateBetween(start, end)
    }

    override fun findCalculationHistoryByUsername(username: String): List<CalculationHistory> {
        return historyRepository.findAllByUsername(username)
    }

    override fun findAll(page: Int, size: Int): Page<CalculationHistory> {
        return historyRepository.findAll(PageRequest.of(page, size))
    }

}