<div align="center">
  <img src="src/test/resources/images.png" width="500" alt="Megastroy logo"/>

  <h1>Проект по автоматизации тестирования сайта <font color="#B22222">megastroy.com</font></h1>

  <p>Автоматизированные UI-тесты интернет-магазина строительных материалов</p>

  <p>
    🔗 <a href="https://megastroy.com" target="_blank">Перейти на сайт megastroy.com</a>
  </p>
</div>

---

## 📑 Содержание

- [О проекте](#-о-проекте)
- [Использованный стек технологий](#-использованный-стек-технологий)
- [Архитектура и подход к автоматизации](#-архитектура-и-подход-к-автоматизации)
- [Тестовое покрытие](#-тестовое-покрытие)
- [Структура проекта](#-структура-проекта)
- [Запуск тестов](#-запуск-тестов)
- [Параметры запуска](#-параметры-запуска)
- [Allure Report](#-allure-report)
- [Selenoid и видеозапись](#-selenoid-и-видеозапись)
- [Jenkins](#-jenkins)
- [Allure TestOps](#-allure-testops)
- [Jira](#-jira)
- [Рекомендации по работе с тестовыми данными](#-рекомендации-по-работе-с-тестовыми-данными)
- [Roadmap](#-roadmap)
- [Об авторе](#-об-авторе)

---

## 🔍 О проекте

Проект представляет собой UI-фреймворк для автоматизации функциональных сценариев интернет-магазина строительных материалов **Megastroy**.

Цель проекта — автоматизировать ключевые пользовательские сценарии и продемонстрировать практическое применение современных подходов к UI-тестированию: Page Object, Component Object, Fluent Interface, Allure и удалённый запуск браузера в Selenoid.

### Автоматизированные пользовательские сценарии

- регистрация нового пользователя;
- авторизация существующего пользователя;
- поиск товара через поисковую строку;
- добавление товара в корзину;
- создание заказа с самовывозом и оплатой наличными;
- смена выбранного магазина;
- добавление товара в избранное.

На текущем этапе реализовано **7 UI-тестов**.

---

## 💻 Использованный стек технологий

<p align="center">
  <a href="https://www.oracle.com/java/"><img src="https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 17"/></a>
  <a href="https://gradle.org/"><img src="https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&amp;logo=gradle&amp;logoColor=white" alt="Gradle"></a>
  <a href="https://junit.org/junit5/"><img src="https://img.shields.io/badge/JUnit_5-25A162?style=for-the-badge&amp;logo=junit5&amp;logoColor=white" alt="JUnit 5"></a>
  <a href="https://selenide.org/"><img src="https://img.shields.io/badge/Selenide-43B02A?style=for-the-badge&amp;logo=selenium&amp;logoColor=white" alt="Selenide"></a>
  <a href="https://www.jenkins.io/"><img src="https://img.shields.io/badge/Jenkins-D24939?style=for-the-badge&amp;logo=jenkins&amp;logoColor=white" alt="Jenkins"></a>
  <a href="https://aerokube.com/selenoid/latest/"><img src="https://img.shields.io/badge/Selenoid-1E8CBE?style=for-the-badge&logo=docker&logoColor=white" alt="Selenoid"/>
  <a href="https://allurereport.org/"><img src="https://img.shields.io/badge/Allure_Report-FF6B35?style=for-the-badge&amp;logo=allure&amp;logoColor=white" alt="Allure Report"></a>
  <a href="https://www.atlassian.com/software/jira"><img src="https://img.shields.io/badge/Jira-0052CC?style=for-the-badge&amp;logo=jira&amp;logoColor=white" alt="Jira"></a>
  <a href="https://allurereport.org/allure-testops/"><img src="https://img.shields.io/badge/Allure_TestOps-FF6B35?style=for-the-badge&amp;logo=allure&amp;logoColor=white" alt="Allure TestOps"></a>
</p>

| Категория | Технология |
|---|---|
| Язык программирования | Java 17 |
| Сборщик | Gradle 8.14.5 |
| UI automation | Selenide 7.16.2 |
| Тестовый фреймворк | JUnit 5.9.3 |
| Отчётность | Allure Report 2.32.0 |
| Удалённый запуск браузера | Selenoid |
| Генерация тестовых данных | JavaFaker 1.0.2 |
| Архитектурный подход | Page Object + Component Object + Fluent Interface |

---

## 🏗 Архитектура и подход к автоматизации

### 1. Page Object

Для каждой ключевой страницы сайта создан отдельный класс, который инкапсулирует локаторы и действия пользователя.

Примеры:

```text
MainPage
LoginPage
RegistrationPage
ProductItemPage
BasketPage
OrderPage
FavoritePage
```

Тест содержит бизнес-шаги, а детали взаимодействия с UI находятся внутри Page Object.

### 2. Component Object

Повторно используемые элементы вынесены в отдельные компоненты:

```text
PopupComponent
SearchBarComponent
UserFormComponent
```

Это позволяет не дублировать одинаковую логику между страницами и упрощает дальнейшее развитие проекта.

### 3. Fluent Interface

Методы Page Object возвращают текущую страницу или следующую страницу, поэтому сценарии читаются как последовательность действий пользователя:

```java
productItem
        .openProductItemPage(testData.FIRST_PRODUCT_NUMBER_ITEM)
        .checkNameProductItem(testData.FIRST_PRODUCT_ITEM_NAME)
        .clickAddInBasket()
        .openBasket()
        .checkAddedBasketItem(testData.FIRST_PRODUCT_ITEM_NAME);
```

### 4. Allure + Selenide

Каждый тест запускается с интеграцией `AllureSelenide`, а после завершения теста автоматически собираются артефакты:

- скриншот;
- исходный код страницы (Page Source);
- логи браузерной консоли;
- ссылка на видео прогона в Selenoid.

### 5. Работа с нестабильными popup-окнами

Для автоматического удаления внешних popup-элементов используется `PopupHelper`, который запускает отдельный daemon-поток и периодически пытается закрывать popup-элементы Mindbox / PopMechanic.

---

## 🧪 Тестовое покрытие

| № | Сценарий | Проверяемая функциональность | Тип |
|---:|---|---|---|
| 1 | Успешная регистрация | Заполнение регистрационной формы и проверка профиля | Positive |
| 2 | Успешная авторизация | Вход существующего пользователя и проверка профиля | Positive |
| 3 | Поиск товара | Поиск товара через поисковую строку | Positive |
| 4 | Добавление в корзину | Добавление товара и проверка корзины | Positive |
| 5 | Создание заказа | Корзина → оформление → самовывоз → оплата → подтверждение | E2E / Positive |
| 6 | Смена магазина | Выбор города и магазина | Positive |
| 7 | Добавление в избранное | Добавление товара и проверка списка избранного | Positive |

### Основные E2E-цепочки

**Покупка товара:**

```text
Открытие товара
      ↓
Проверка названия
      ↓
Добавление в корзину
      ↓
Переход в корзину
      ↓
Проверка товара
      ↓
Оформление заказа
      ↓
Заполнение данных покупателя
      ↓
Выбор самовывоза
      ↓
Проверка магазина
      ↓
Выбор оплаты
      ↓
Подтверждение заказа
```

**Авторизация:**

```text
Страница авторизации
      ↓
Email + пароль
      ↓
Запомнить пользователя
      ↓
Вход
      ↓
Проверка имени и email в профиле
```

---

## 📂 Структура проекта

```text
Megastroy/
├── gradle/
│   └── wrapper/                     # Gradle Wrapper
├── src/
│   └── test/
│       ├── java/
│       │   ├── helpers/             # Вспомогательные классы
│       │   │   ├── Attach           # Аттачи для Allure
│       │   │   └── PopupHelper      # Работа со всплывающими окнами
│       │   │
│       │   ├── pages/               # Page Objects
│       │   │   ├── components/      # Переиспользуемые UI-компоненты
│       │   │   │   ├── PopupComponent
│       │   │   │   ├── SearchBarComponent
│       │   │   │   └── UserFormComponent
│       │   │   ├── BasketPage
│       │   │   ├── FavoritePage
│       │   │   ├── LoginPage
│       │   │   ├── MainPage
│       │   │   ├── OrderPage
│       │   │   ├── OrderSuccessPage
│       │   │   ├── ProductItemPage
│       │   │   ├── RegistrationPage
│       │   │   ├── SearchResultPage
│       │   │   └── ShopSelectionPage
│       │   │
│       │   ├── testData/            # Конфигурация и тестовые данные
│       │   │   ├── ConfigData
│       │   │   └── TestData
│       │   │
│       │   └── tests/               # Тестовые классы
│       │       ├── MegastroyTests
│       │       └── TestBase
│       │
│       └── resources/
│           └── images.png           # Логотип проекта
│
├── build.gradle                     # Конфигурация Gradle
├── settings.gradle                  # Настройки Gradle-проекта
├── gradlew                           # Gradle Wrapper для Linux/macOS
├── gradlew.bat                       # Gradle Wrapper для Windows
└── README.md
```

---

## ▶️ Запуск тестов

### Локальный запуск

Клонировать репозиторий и перейти в директорию проекта:

```bash
git clone https://github.com/KhismatullinTM/MegastroyProject.git
cd MegastroyProject
```

Запуск всех тестов:

```bash
./gradlew clean test
```

Для Windows:

```bash
gradlew.bat clean test
```

---

## ⚙️ Параметры запуска

В проекте используется передача параметров через `System.getProperty()`.

| Параметр | Назначение | Значение по умолчанию |
|---|---|---|
| `URL` | URL тестового стенда | `https://sterlitamak.megastroy.com` |
| `BROWSER` | Браузер | `chrome` |
| `BROWSER_SIZE` | Размер окна браузера | опционально |
| `BROWSER_VERSION` | Версия браузера в Selenoid | опционально |
| `HEADLESS` | Headless-режим | `false` |
| `SELENOID_URL` | URL удалённого WebDriver | настроен по умолчанию в `TestBase` |

Пример запуска с параметрами:

```bash
./gradlew clean test \
  -DURL=https://sterlitamak.megastroy.com \
  -DBROWSER=chrome \
  -DBROWSER_SIZE=1920x1080 \
  -DBROWSER_VERSION=128.0 \
  -DHEADLESS=true \
  -DSELENOID_URL=https://<user>:<password>@<selenoid-host>/wd/hub
```

---

## 📊 Allure Report

Проект использует `allure-junit5` и `allure-selenide` для формирования подробного отчёта о выполнении тестов.

После запуска тестов результаты находятся в:

```text
build/allure-results
```

Для генерации и открытия локального отчёта:

```bash
./gradlew allureReport
./gradlew allureServe
```

В отчёте доступны результаты тестов и прикреплённые материалы, которые собираются после каждого теста.

<img src="src/test/resources/AllureMainPage.png" width="500" alt="Allure Report"/>

<img src="src/test/resources/AllureTestPage.png" width="500" alt="Allure Report"/>

---

## 🎥 Selenoid и видеозапись

Удалённый запуск выполняется в **Selenoid**. Для браузера включены:

```java
"enableVNC", true
"enableVideo", true
```

После каждого теста в Allure прикладываются:

- скриншот последнего состояния браузера;
- Page Source;
- browser console logs;
- видео тестового прогона.

Видео строится на основе `sessionId` браузерной сессии и подключается к Allure-отчёту как attachment.

![Demo](src/test/resources/ScreencastMegastroy.gif)

---

## 🔧 Jenkins

Подготовлена возможность использовать проект в удалённом запуске через Jenkins за счёт передачи параметров Gradle через `System.getProperty()`.


Jenkins: [Megastroy_tests](https://jenkins.qa.guru/job/Megastroy_teats/)

<img src="src/test/resources/Jenkins_MainPage.png" width="500" alt="Jenkins"/>


---

---
Планируемый сценарий:

```text
GitHub
   ↓
Jenkins
   ↓
Gradle
   ↓
Selenoid
   ↓
UI Tests
   ↓
Allure Report
```

---

## 📈 Allure TestOps

Интеграция с Allure TestOps [Megastroy_project](https://allure.qa.guru/project/5382/dashboards/5688).

Планируемая задача — использовать TestOps для хранения и анализа тест-кейсов, истории запусков и покрытия автоматизацией.

<img src="src/test/resources/AllureTestOps.png" width="500" alt="AllureTestOps"/>

---

## 🔗 Jira


Планируемое назначение интеграции:

- связывание автоматизированных тестов с задачами Jira;
- отслеживание дефектов;
- связь требований, тест-кейсов и результатов прогонов.

<img src="src/test/resources/jira.png" width="500" alt="JIRA"/>

---

## 🔐 Рекомендации по работе с тестовыми данными

В проекте используется `JavaFaker` для генерации уникальных регистрационных данных:

```java
public String USER_FIRST_NAME = fakerRu.name().firstName();
public String USER_LAST_NAME = fakerRu.name().lastName();
public String USER_EMAIL = fakerEng.internet().emailAddress();
```

Такой подход снижает вероятность повторного использования одинаковых данных при регистрации.

Для существующего пользователя в текущей реализации используются заранее заданные данные в `TestData`. При переносе проекта в публичный CI/CD рекомендуется вынести такие значения в переменные окружения или секретное хранилище.

---

## 🗺 Roadmap

- [ ] Интеграция с Jira
- [ ] Интеграция с Allure TestOps
- [ ] Настройка Jenkins Pipeline / CI/CD
- [ ] Вынесение секретов и тестовых учётных данных в переменные окружения
- [ ] Добавление негативных тест-кейсов
- [ ] Расширение покрытия корзины и оформления заказа
- [ ] Добавление API-тестов
- [ ] Параллельный запуск тестов в Selenoid
- [ ] Добавление тегов JUnit для выборочного запуска `smoke` / `regression`

---

## 👨‍💻 Об авторе

**Temo Khismatullin**

Fullstack QA Engineer

Проект разработан в рамках обучения и практики автоматизации тестирования веб-приложений.

---

<div align="center">
  <sub>Megastroy UI Automation Project</sub>
</div>
