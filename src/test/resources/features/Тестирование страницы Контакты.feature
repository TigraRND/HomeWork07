# language: ru
  Функционал: Страница Контакты
    Предыстория: Подготовка
      * Инициализация драйвера

    @Test
    Сценарий: Проверка адреса на странице Контакты
      Когда Пользователь переходит на страницу Контакты
      Тогда Отображается контактный адрес "125167, г. Москва, Нарышкинская аллея., д. 5, стр. 2, тел. +7 499 938-92-02"
      * Закрываем драйвер