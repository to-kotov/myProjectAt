Feature: Получение статей
  Пользователь хочет получить список статей

  @smoke
  Scenario Template: : Отправть запрос на получение статей Название
    Given Отправить запрос статей  с "<URL>" и получить ответ со статусом
    Then Код ответа : "<status>"
    Examples:
      | URL           | status |
      | articles.json | 200    |
      |               | 404    |
      | wrong.json    | 404    |
