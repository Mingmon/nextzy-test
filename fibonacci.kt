// another runnable fibonacci file is in app/src/test/java/fibonacci/fibonacci.kt

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