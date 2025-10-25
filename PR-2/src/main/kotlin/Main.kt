fun main() {
    while (true)
    {
        println("Введите необходимый номер задания:")
        val task = readln().trim()

        if (task == "0")
        {
            println("Заверщение программы!")
            break
        }

        val exercise = task.toInt()
        when (exercise)
        {
            1 ->
            {
                println("Эта программа подсчитывается количество различных цифр в массиве и выводит количество различных цифр используемых в данном массиве")
                println("-----------------------------------------------------------------------------------------------------------------------------------")
                print("Введите количество столбцов:")
                val column = readln().trim().toInt()
                print("Введите количество строк:")
                val row = readln().trim().toInt()

                if (column <= 0 || row <= 0)
                {
                    print("Количество строк и столбцов должно быть больше 0!")
                    return
                }
                //Рандомно генерим числа
                val matrix = Array(row)
                {
                    Array(column)
                    {
                        (100.. 999).random()
                    }
                }
                // Вывод матрицы
                println("\nСформированная матрица:")
                for (i in matrix.indices)
                {
                    for (j in matrix[i].indices)
                    {
                        print("${matrix[i][j]}".padStart(4))
                    }
                    println()
                }
                //Создаем множество типа Char
                val unique = mutableSetOf<Char>()
                for (i in matrix.indices)
                {
                    for (j in matrix[i].indices)
                    {
                        //Превраащем каждый элемент матрицы в строку
                        val numbs = matrix[i][j].toString()
                        unique.addAll(numbs.toSet()) //Добавляем все уникальные символы в переменную
                    }
                }

                println("\nВ массиве использовано ${unique.size} различных цифр: ${unique.sorted().joinToString(", ")}")

            }
            2 ->
            {
                println("Эта программа выясняет, симметричен ли массив относительно главной диагонали.")
                println("-----------------------------------------------------------------------------------------------------------------------------------")
                //Создаю матрицу
                val matrix2 = arrayOf(
                    intArrayOf(5, 9, 6, 7, 2),
                    intArrayOf(9, 8, 4, 5, 3),
                    intArrayOf(6, 4, 3, 8, 7),
                    intArrayOf(7, 5, 8, 4, 8),
                    intArrayOf(2, 3, 7, 8, 1)
                )

                //Выводим массив
                for (row in matrix2)
                {
                    for (value in row)
                    {
                        print("${value}".padStart(4))
                    }
                    println()
                }

                val n = matrix2.size //Переменная для хранения размера матрицы
                var symmetry = true //Флаг симметричности

                for (i in 0 until n)
                {
                    for (j in 0 until n)
                    {
                        if (matrix2[i][j] != matrix2[j][i]) //Если симметрия не соблюдена
                        {
                            symmetry = false
                            break
                        }
                    }
                    if (!symmetry)break
                }

                if (symmetry)
                {
                    println("Массив симметричен относительно главной диагонали")
                }
                else
                {
                    println("Матрица НЕ симметрична")
                }
            }
            3 ->
            {

            }
            4->
            {
                println("Эта программа находит пересечения двух массивов с учётом количества повторений.")
                println("-----------------------------------------------------------------------------------------------------------------------------------")
                println("Введите первый массив: ")
                val input1 = readln().trim().toInt()
                println("Введите второй массив: ")
                val input2 = readln().trim().toInt()

                if (input1 <= 0 || input2 <= 0)
                {
                    print("Массив не может быть пустым!")
                }


            }
        }
    }
}