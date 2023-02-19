# Сжать строку "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB" в "A4B3C2XYZD4E3F3A6B28"

_Задание на собеседовании в компанию [Yandex](https://yandex.ru) 17.02.2022_

### Задача

Дана строка, состоящая из букв A-Z:

"AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB"

Нужно написать функцию _rle_, которая на выходе даст строку вида:

"A4B3C2XYZD4E3F3A6B28"

И сгенерирует любую ошибку, если на вход пришла невалидная строка.

Пояснения:
1. Если символ встречается 1 раз, он остается без изменений.
2. Если символ повторяется более 1 раза, к нему добавляется количество повторений.

### Пример

| На входе | На выходе |
|---------|-----------|
| AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB | A4B3C2XYZD4E3F3A6B28 |
