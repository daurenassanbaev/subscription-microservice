## 📦 Subscription Microservice

Микросервис для управления пользователями и их подписками на цифровые сервисы (YouTube Premium, VK Музыка, Яндекс.Плюс, Netflix и др.). Реализован с использованием **Spring Boot 3**, **PostgreSQL**, **Redis** и контейнеризирован с помощью **Docker**.

---

### 🚀 Функциональные возможности

#### 👤 Пользователи (`/users`)

* `POST /users` — создать пользователя
* `GET /users/{id}` — получить информацию о пользователе
* `PUT /users/{id}` — обновить данные пользователя
* `DELETE /users/{id}` — удалить пользователя

#### 📺 Подписки (`/users/{userId}/subscriptions`)

* `POST /users/{id}/subscriptions` — добавить подписку пользователю
* `GET /users/{id}/subscriptions` — получить список подписок пользователя
* `DELETE /users/{id}/subscriptions/{sub_id}` — удалить подписку

#### 🏆 ТОП подписок

* `GET /subscriptions/top` — получить ТОП-3 популярных подписок

---

### 🧰 Технологии

* Java 17
* Spring Boot 3
* PostgreSQL
* Redis (кэширование)
* Flyway (миграции)
* SLF4J (логирование)
* Docker / Docker Compose
* Swagger / OpenAPI

---

### ⚙️ Как запустить проект

#### 1. Клонируй репозиторий

```bash
git clone git@github.com:daurenassanbaev/subscription-microservice.git
cd subscription-microservice
```

#### 2. Создай `.env` файл в корне проекта

```env
DB_URL=jdbc:postgresql://postgres:5432/tech_task_db
POSTGRES_DB=tech_task_db
DB_USERNAME=postgres
DB_PASSWORD=postgres
REDIS_HOST=redis
REDIS_PORT=6379
```

#### 3. Собери и запусти контейнеры

```bash
docker-compose --env-file .env up --build
```

#### 4. Swagger-документация

Доступна по адресу:
🔗 [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

---

### 📁 Структура проекта

```
├── src/main/java
│   ├── controller
│   ├── service
│   ├── model
│   ├── repository
│   └── exception
├── src/main/resources
│   └── db/migration     # Flyway миграции
├── Dockerfile
├── docker-compose.yml
├── .env
└── README.md
```