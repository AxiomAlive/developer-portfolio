package Div2

import kotlin.jvm.JvmStatic
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

object A {
    @JvmStatic
    fun main(args: Array<String>) {
        val input = Scanner(BufferedReader(InputStreamReader(System.`in`)))
        val testCases = input.nextInt()
        loop@ for (testCase in 0 until testCases) {
            val x = input.nextInt()
            val k = input.nextInt()
            val charCombinations = ArrayList<CharArray>()
            var currentValue = x
            do {
                val chars = currentValue.toString().toCharArray()
                var charSum = 0
                for (digit in chars) {
                    charSum += digit.toString().toInt()
                }
                if (charSum % k == 0) {
                    println(currentValue)
                    continue@loop
                }
                currentValue++
            } while (true)
        }
    }
}