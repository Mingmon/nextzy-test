package fibonacci

import org.junit.Test

class Fibonacci {
    @Test
    fun main() {
        val fi = fibonacci(9)
        fi.forEach {
            print("$it ")
        }
    }

    private fun fibonacci(n: Int): ArrayList<Int> {
        val fi = arrayListOf<Int>()
        fi.add(0)
        fi.add(1)
        for (i in 2 until n) {
            val newFi = fi[i - 1] + fi[i - 2]
            if (newFi > n) break
            else {
                fi.add(newFi)
            }
        }
        return fi
    }
}