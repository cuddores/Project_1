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

                if (letters.isEmpty())  //Проверяю строчку на наличие символов
                {
                    print("Строка пустая")
                    return //Возвращаем если строка пустая
                }

                var result = "" //Переменная для хранения результата
                var currentLetter = letters[0] //Переменная которй присваиваем текущий символ(первый в нашем случае)
                var count = 1 //счетчик уникальных символов

                for (i in 1 until letters.length) //Прохожусь по всей строке
                {
                    if (letters[i] == currentLetter)
                    {
                        count++
                    }
                    else
                    {
                        result += "$currentLetter$count" // Добавляю текущий символ и количество его повторений в результат
                        currentLetter = letters[i] //Переходи на следующий символ дял обработки
                        count = 1 //Сбрасывем счетчик повторений для нового символа
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
                    return //Возвращаем если строка пустая
                }

                val sortcombine = combination.toCharArray().sorted() //преобразую строку в список символов и сортирую
                var count = 1 //счетчик повторяющихся букв
                var currentChar = sortcombine[0] //Переменная которй присваиваем текущий символ
                var result = ""

                for (i in 1 until sortcombine.size)
                {
                    if (sortcombine[i] == currentChar) //Если текущий символ в цикле такой же как currentChar
                    {
                        count++
                    }
                    else
                    {
                        result += "$currentChar - $count\n" //собираю результат
                        currentChar = sortcombine[i] //обновляю на новый символ
                        count = 1 //сбрасываю счетчик
                    }

                }
                result += "$currentChar - $count\n" //для последнего символа
                println("\nРезультат:")
                println(result)
            }

            3 -> {
                print("Это приложение, которое преобразует введенное пользователем натуральное число из 10-ичной системы в двоичную\n")
                print("Введите число для преобразования:")
                val number = readln().trim()

                if (number.isEmpty()) //Проверяю строчку на наличие символов
                {
                    print("Необходимо ввести число")
                    return //Возвращаем если строка пустая
                }

                val convert = number.toIntOrNull() //Конвертирую number в int

                if ((convert == null) || (convert <= 0)) //Проверям ввод (и чтобы число было натуральное)
                {
                    print("Введите натуральное число")
                    return
                }

                var result = "" //Переменная для результата
                var temp = convert //Временная переменная для вычесления
                while (temp > 0)
                {
                    val remains = temp % 2 //Остаток от деления на 2
                    result = remains.toString() + result //Перекидываю бит в начало результата
                    temp /= 2 //Делим дальше
                }
                println("Результат: $result")
            }

            4 -> {
                print("Это приложение, с помощью которого пользователь, введя два числа и символ операции, узнает результат\n")
                print("Введите число в формате (ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ): ")
                val calculate = readln().trim()

                val parts = calculate.split(" ") //Разделаю строку по пробелам

                val numb1 = parts[0].toDoubleOrNull() //Первое число
                val numb2 = parts[1].toDoubleOrNull() //Второе число
                val operation = parts[2] //Операция

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

                if (n <= 0 || x <= 1) //Проверка корректности входных данных
                {
                    println("n должно быть > 0, x должно быть > 1")
                    return
                }

                var y = 0 //Показатель степени который нам нужен
                var check = 1 //Значение x^y, начинаем с x^0 = 1

                while (check < n) //Перебираю степени x^y, пока не достигну n
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
                val result: String //Переменная для результата

                if (conv1 % 2 == 0 && conv2 % 2 == 0)
                {
                    println("Создать нечетное число невозможно")
                    return
                }
                else if (conv1 % 2 == 1)
                {
                    result = "$conv2$conv1" //Ставлю нечетную в конце
                }
                else
                {
                    result = "$conv1$conv2" //Ставлю нечетную в конце
                }

                println("Нечетное число: $result")
            }
        }
    }
}