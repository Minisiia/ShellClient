## ShellClient
Create another application on Spring Boot, deploy it locally, but on a different port (eg server.port=8099). Connect it to your DB schema. Add a Task entity and an endpoint to retrieve the task by id. Refer from the first application to the second through this endpoint and retrieve the employee using the second application with shell client
## 8. Spring 10. Spring Boot
## Завдання 3
Створіть ще один застосунок на Spring Boot, розгорніть його локально, але на іншому порту (наприклад, server.port=8099). Під'єднайте його до вашої схеми БД. 
Додайте сутність Task та кінцеву точку для отримання task за айді. 
Зверніться з першого застосунку до другого за цією кінцевою точкою та отримайте task за допомогою другого застосунку.
Реалізувати за допомогою Spring Shell.

## Заметки

**Spring Shell** - это библиотека для создания интерактивных командных оболочек (CLI) на основе Spring Framework. Она предоставляет API для создания команд, аргументов и опций, а также удобный способ обработки пользовательского ввода и вывода результатов.

Некоторые из основных возможностей Spring Shell включают в себя:

- Определение команд, которые могут выполняться из командной строки
- Поддержка аргументов и опций команд
- Возможность создания пользовательского интерфейса в интерактивной консоли
- Поддержка валидации пользовательского ввода и обработки исключений
- Интеграция с Spring Framework и Spring Boot
- Поддержка встроенных команд, таких как help и exit

### Аннотации Spring Shell
**@ShellMethod** - используется для обозначения метода, который может быть вызван из командной оболочки. Принимает один обязательный параметр - описание метода в виде строки. Может принимать дополнительные параметры, такие как key (для указания альтернативного имени метода), value (для указания результата, возвращаемого методом), prefix (для указания префикса, добавляемого к аргументам метода при вызове из командной оболочки) и другие.

**@ShellOption** - используется для обозначения параметра метода, который может быть передан через аргументы командной строки. Принимает два обязательных параметра - имя параметра и описание в виде строки. Может принимать дополнительные параметры, такие как defaultValue (значение по умолчанию), arity (число аргументов), mandatory (обязательность параметра) и другие.

**@ShellComponent** - используется для обозначения класса, который содержит методы, вызываемые из командной оболочки. Аннотированный класс должен быть зарегистрирован в контексте Spring.

**@ShellMethodAvailability** - используется для обозначения метода, который определяет, доступен ли определенный метод для вызова из командной оболочки. Метод должен возвращать значение типа Availability.

**@ShellOptionAvailability** - используется для обозначения метода, который определяет, доступен ли определенный параметр для использования в методе, вызываемом из командной оболочки. Метод должен принимать в качестве параметра значение типа ValueProviderContext и возвращать значение типа Availability.
