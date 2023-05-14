# Подсчитать количество кораблей на поле для морского боя

_Задание на собеседовании в компанию [Тинькофф](https://www.tinkoff.ru/) 12.05.2023_

### Задача

Есть матрица NxN, состоящая из 0 и 1 и отражающая расположения кораблей на поле для морского боя.
1. Кораблей может быть любое количество.
2. Размер кораблей от 1×1 до 1×N.
3. Корабли никак не соприкасаются друг с другом.
4. Корабли располагаются горизонтально и вертикально.
   
Необходимо подсчитать количество кораблей.

### Пример

[1, 1, 0, 0, 1, 0],

[0, 0, 0, 0, 1, 01,

[1, 0, 1, 0, 1, 0],

[0, 0, 0, 0, 0, 0],

[1, 0, 1, 1, 1, 1],

[0, 0, 0, 0, 0, 0]

Ответ: 6

