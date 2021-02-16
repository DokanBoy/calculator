package pw.zakharov.calculator.repository

import org.springframework.data.repository.CrudRepository
import pw.zakharov.calculator.model.CalculationHistory
import java.util.*

interface HistoryRepository : CrudRepository<CalculationHistory, Long> {

    fun findAllByDateBetween(start: Date, end: Date): List<CalculationHistory>

}