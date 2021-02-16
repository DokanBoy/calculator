package pw.zakharov.calculator.model

import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "calculation_history")
@JsonInclude(JsonInclude.Include.NON_NULL)
data class CalculationHistory(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    @ManyToOne val executor: User?,
    val expression: String,
    val evaluateException: String? = null,
    val evaluatedValue: Double? = null,
    val date: Date
) {
    constructor() : this(null, null, "", null, null, Date())
}