package pw.zakharov.calculator.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import pw.zakharov.calculator.model.CalculationHistory
import java.util.*

interface HistoryRepository : CrudRepository<CalculationHistory, Long> {

    fun findAllByDateBetween(start: Date, end: Date): List<CalculationHistory>

    @Query("SELECT ch FROM CalculationHistory ch WHERE ch.executor.username = :username")
    fun findAllByUsername(@Param("username") username: String): List<CalculationHistory>

}