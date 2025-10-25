fun main() {
    while (true)
    {
        println("Введите номер необходимого задания (1-6) или 0 для выхода:")
        val input = readln().trim()

        if (input == "0")
        {
            println("Выход из программы")
            break
        }
        val exercise = input.toInt()

        when(exercise)
        {
            1 -> {
                print("Это приложение, которое подсчитывает количество подряд идущих одинаковых символов во введенной строке\n")
                print("Введите комбинацию из подряд идущих букв(Например,AAADSSSRRHAA):")
                val letters = readln().trim()

                if (letters.isEmpty())
                {
                    print("Строка пустая")
                    return
                }

                var result = ""
                var currentLetter = letters[0]
                var count = 1

                for (i in 1 until letters.length)
                {
                    if (letters[i] == currentLetter)
                    {
                        count++
                    }
                    else
                    {
                        result += "$currentLetter$count"
                        currentLetter = letters[i]
                        count = 1
                    }
                }
                result += "$currentLetter$count"
                println("Результат: $result")
            }

            2 -> {
                print("Это приложение, которое подсчитывает количество различных символов во введенной строке\n")
                print("Введите комбинацию из рандомных букв(с повторениями):")
                val combination = readln().trim()

                if (combination.isEmpty())
                {
                    print("Строка пустая")
                    return
                }

                val sortcombine = combination.toCharArray().sorted()
                var count = 1
                var currentChar = sortcombine[0]
                var result = ""

                for (i in 1 until sortcombine.size)
                {
                    if (sortcombine[i] == currentChar)
                    {
                        count++
                    }
                    else
                    {
                        result += "$currentChar - $count\n"
                        currentChar = sortcombine[i]
                        count = 1
                    }

                }
                result += "$currentChar - $count\n"
                println(result)
            }

            3 -> {
                print("Это приложение, которое преобразует введенное пользователем натуральное число из 10-ичной системы в двоичную\n")
                print("Введите число для преобразования:")
                val number = readln().trim()

                if (number.isEmpty())
                {
                    print("Необходимо ввести число")
                    return
                }

                val convert = number.toIntOrNull()

                if ((convert == null) || (convert <= 0))
                {
                    print("Введите натуральное число")
                    return
                }

                var result = ""
                var temp = convert
                while (temp > 0)
                {
                    val remains = temp % 2
                    result = remains.toString() + result
                    temp /= 2
                }
                println("Результат: $result")
            }

            4 -> {
                print("Это приложение, с помощью которого пользователь, введя два числа и символ операции, узнает результат\n")
                print("Введите число в формате (ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ): ")
                val calculate = readln().trim()

                val parts = calculate.split(" ")

                val numb1 = parts[0].toDoubleOrNull()
                val numb2 = parts[1].toDoubleOrNull()
                val operation = parts[2]

                if (numb1 == null || numb2 == null)
                {
                    println("Ошибка: одно из введенных значений не является числом.")
                    return
                }

                val res = when (operation)
                {
                    "+" -> numb1 + numb2
                    "-" -> numb1 - numb2
                    "*" -> numb1 * numb2
                    "/" -> {
                        if (numb2 == 0.0)
                        {
                            println("Деление на ноль не возможно")
                            return
                        }
                        numb1 / numb2
                    }

                    else ->
                    {
                        println("Некорреткная операция, допустимы только: + - * /")
                    }
                }
                println("Результат $res")
            }

            5 -> {
                print("Это приложение, с помощью которого пользователь, введя целое число n и основание степени x узнает, существует ли целочисленный показатель степени y\n" +
                        "для которого выполняется равенство x^y = n. \n"
                )

                print("Введите число n:")
                val n = readln().trim().toInt()
                print("Введите основание степени x:")
                val x = readln().trim().toInt()

                if (n <= 0 || x <= 1)
                {
                    println("n должно быть > 0, x должно быть > 1")
                    return
                }

                var y = 0
                var check = 1

                while (check < n)
                {
                    check *= x
                    y++
                }

                if (check == n)
                {
                    println("Целочисленный показатель степени: y = $y")
                }
                else
                {
                    println("Целочисленный показатель не существует")
                }
            }

            6 -> {
                print("Это приложение, с помощью которого пользователь, введя две цифры получает (или нет) нечетное число\n")
                print("Введите первую цифру(от 0 до 9): ")
                val a = readln().trim()
                print("Введите вторую цифру(от 0 до 9): ")
                val b = readln().trim()

                if (a.length != 1 || !a[0].isDigit() || b.length != 1 || !b[0].isDigit())
                {
                    println("МОЖНО ВВОДИТЬ ТОЛЬКО ОДНУ ЦИФРУ (0-9)")
                    continue
                }

                val conv1 = a.toInt()
                val conv2 = b.toInt()


                if (conv1 == conv2)
                {
                    print("Цифры должны отличаться")
                    return
                }
                val result: String

                if (conv1 % 2 == 0 && conv2 % 2 == 0)
                {
                    println("Создать нечетное число невозможно")
                    return
                }
                else if (conv1 % 2 == 1)
                {
                    result = "$conv2$conv1"
                }
                else
                {
                    result = "$conv1$conv2"
                }

                println("Нечетное число: $result")
            }
        }
    }
}