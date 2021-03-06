package pw.zakharov.calculator.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import pw.zakharov.calculator.model.CalculationHistory
import java.util.*

interface HistoryRepository : JpaRepository<CalculationHistory, Long> {

    fun findAllByDateBetween(start: Date, end: Date): List<CalculationHistory>

    @Query("SELECT ch FROM CalculationHistory ch WHERE ch.executor.username = :username")
    fun findAllByUsername(@Param("username") username: String): List<CalculationHistory>

    fun findAllByExpressionLike(expression: String): List<CalculationHistory>

}