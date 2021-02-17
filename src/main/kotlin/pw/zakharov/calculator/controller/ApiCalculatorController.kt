package pw.zakharov.calculator.controller

import org.springframework.format.annotation.DateTimeFormat
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pw.zakharov.calculator.model.CalculationHistory
import pw.zakharov.calculator.model.dto.CalculationRequest
import pw.zakharov.calculator.service.HistoryService
import pw.zakharov.calculator.service.MathService
import java.util.*

@RestController
class ApiCalculatorController(
    private val mathService: MathService,
    private val historyService: HistoryService
) {

    @Throws(IllegalArgumentException::class)
    @PostMapping("/api/evaluate")
    fun evaluate(@RequestBody calculationRequest: CalculationRequest): Double {
        return mathService.evaluateDouble(calculationRequest.expression, calculationRequest.username)
    }

    @GetMapping("/api/evaluates/{username}")
    fun evaluatesForUser(@PathVariable username: String): List<CalculationHistory> {
        return historyService.findCalculationHistoryByUsername(username)
    }

    @GetMapping("/api/evaluates/date")
    fun lastEvaluates(
        @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") start: Date,
        @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss") end: Date,
    ): List<CalculationHistory> {
        return historyService.findCalculationHistoryBetweenDates(start, end)
    }

    @GetMapping("/api/evaluates")
    fun lastEvaluates(@RequestParam page: Int, @RequestParam size: Int): List<CalculationHistory> {
        return historyService.findAll(page, size).toList()
    }

    @GetMapping("/api/evaluates/similar")
    fun similarEvaluates(@RequestParam pattern: String): List<CalculationHistory> {
        return historyService.findSimilar(pattern)
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleException(e: IllegalArgumentException): ResponseEntity<String>? {
        return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
    }

}