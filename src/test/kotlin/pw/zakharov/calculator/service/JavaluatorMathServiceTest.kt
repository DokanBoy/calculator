package pw.zakharov.calculator.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import pw.zakharov.calculator.service.impl.JavaluatorMathService
import java.lang.Math.PI
import java.lang.Math.pow
import kotlin.math.cos
import kotlin.math.ln
import kotlin.math.sin

@SpringBootTest
class JavaluatorMathServiceTest {

    @Autowired
    lateinit var mathService: JavaluatorMathService

    @Test
    fun testIntSum() {
        assertEquals(1.0 + 1.0, mathService.evaluateDouble("1+1", "test"))
        assertEquals(234.0 + 12.0 + 2.0, mathService.evaluateDouble("234+12+2", "test"))
    }

    @Test
    fun testDoubleSum() {
        assertEquals(1.1 + 1.0, mathService.evaluateDouble("1.1+1.0", "test"))
        assertEquals(234.6 + 12.6 + 2.8, mathService.evaluateDouble("234.6+12.6+2.8", "test"))
    }

    @Test
    fun testIntDifference() {
        assertEquals(1.0 - 1.0, mathService.evaluateDouble("1-1", "test"))
        assertEquals(234.0 - 12.0 - 2.0, mathService.evaluateDouble("234-12-2", "test"))
    }

    @Test
    fun testDoubleDifference() {
        assertEquals(1.4 - 1.3, mathService.evaluateDouble("1.4-1.3", "test"))
        assertEquals(234.2 - 12.3 - 2.4, mathService.evaluateDouble("234.2-12.3-2.4", "test"))
    }

    @Test
    fun testIntMultiply() {
        assertEquals(3.0 * 2.0, mathService.evaluateDouble("3*2", "test"))
        assertEquals(12.0 * 12.0 * 2.0, mathService.evaluateDouble("12*12*2", "test"))
    }

    @Test
    fun testDoubleMultiply() {
        assertEquals(1.4 * 1.3, mathService.evaluateDouble("1.4*1.3", "test"))
        assertEquals(12.2 * 12.1 * 2.3, mathService.evaluateDouble("12.2*12.1*2.3", "test"))
    }

    @Test
    fun testIntDivide() {
        assertEquals(6.0 / 2.0, mathService.evaluateDouble("6/2", "test"))
        assertEquals(12.0 / 2.0 / 2.0, mathService.evaluateDouble("12/ 2/2", "test"))
    }

    @Test
    fun testDoubleDivide() {
        assertEquals(6.4 / 2.2, mathService.evaluateDouble("6.4/2.2", "test"))
        assertEquals(12.4 / 2.2 / 2.1, mathService.evaluateDouble("12.4/2.2/2.1", "test"))
    }

    @Test
    fun testFunctions() {
        assertEquals(sin(180.0) + cos(90.0), mathService.evaluateDouble("sin(180)+cos(90)", "test"))
        assertEquals(
            (pow(2.0, 3.0) - 1) * sin(PI / 4) / ln(pow(PI, 2.0)),
            mathService.evaluateDouble("(2^3-1)*sin(pi/4)/ln(pi^2)", "test")
        )
    }

    @Test
    fun testOperationsWithExtraSpaces() {
        assertEquals(1.0 + 1.0, mathService.evaluateDouble("1 + 1", "test"))
        assertEquals(234.0 + 12.0 + 2.0 * 3 / 10, mathService.evaluateDouble("234 + 12+2 *3/10", "test"))
    }

}