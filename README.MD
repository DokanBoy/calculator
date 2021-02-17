# Calculator API

## Запросы

* `POST /api/evaluate`
  <br> Описание: Произвести вычисление, возвращает дробное число.
  <br> Аргументы:
    * username - имя пользователя (передается в теле запроса)
    * expression - выражение для вычисления (передается в теле запроса)
* `GET /api/evaluates/{username}`
  <br> Описание: Получить список вычислений по пользователю.
  <br> Аргументы:
    * username - имя пользователя
* `GET /api/evaluates/date`
  <br> Описание: Получить список вычислений между датами(включительно) start и end
  <br> Аргументы:
    * start - с какой даты
    * end - по какую дату
* `GET /api/evaluates`
  <br> Описание: Получить список вычислений постранично
  <br> Аргументы:
    * page - страница
    * size - количество вычислений на странце

### Поддерживаемые операторы в выражениях
* +: Сумма
* -: Вычитание 
* -: Унарный минус
* *: Умножение
* /: Деление
* ^: Возведение в степень (с ограничениями из Java)
* %: Модуль

### Поддерживаемые функции в выражениях
* abs: absolute value
* acos: arc cosine
* asin: arc sine
* atan: arc tangent
* average: average of arguments
* ceil: nearest upper integer
* cos: cosine
* cosh: hyperbolic cosine
* floor: nearest lower integer
* ln: natural logarithm (base e)
* log: base 10 logarithm
* max: maximum of arguments
* min: minimum of arguments
* round: nearest integer
* sin: sine
* sinh: hyperbolic sine
* sum: sum of arguments
* tan: tangent
* tanh: hyperbolic tangent
* random: pseudo-random number (between 0 and 1)

### Поддерживаемые константы в выражениях
* e: Основание натурального логарифма
* pi: Число PI