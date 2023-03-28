# Вытащить всех потомков по id родителя и поместить в DTO

_Задание на собеседовании в компанию [Ростелеком](https://rt.ru) 28.03.2023_

## Задача

Дан класс _OrganizationWrapper_ и 2 объекта - _OrganizationEntity_ и _OrganizationDto_.

Есть метод _mapper_, куда на вход поступает List< OrganizationDto>.

Есть пример _OrganizationEntity_ и развернутое дерево в формате JSON.

У _RTK_ и _Sber_ parentId = null, так как это головные организации.

У _RTK_ есть 2 подразделения - _Sales_ и _Finance_ (parentId = 1).

У подразделения _Sales_ в свою очередь есть отдел _Marketing_ (parentId = 2).

Необходимо всех потомков _OrganizationEntity_ вытащить по _parentId_ и поместить в DTO.

### Записи в БД:

| id  | parentId | name      |
|-----|----------|-----------|
| 1   | null     | RTK       |
| 2   | 1        | Sales     |
| 3   | 2        | Marketing |
| 4   | 1        | Finance   |
| 5   | null     | Sber      |

### Развернутое дерево в формате JSON

```json
[
  {
    "id": 1,
    "name": "RTK",
    "childs": [
      {
        "id": 2,
        "name": "Sales",
        "childs": [
          {
            "id": 3,
            "name": "Marketing",
            "childs": [
            ]
          }
        ]
      },
      {
        "id": 4,
        "name": "Finance",
        "childs": []
      }
    ]
  },
  {
    "id": 5,
    "name": "SBER",
    "childs": []
  }
]
```