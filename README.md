На тестовом стенде должены быть установлены Node JS, Java, PostgreSQL, MySQL.
Указать в application.properties тестируемую базу данных, а также логин/пароль от БД.
Запустить сервис aqa-shop командой java -jar aqa-shop.jar
Запустить симулятор npm start
Запускаем тесты ./gradlew test -Dselenide.headless=true --info
Отчет по тестам Allure запускается командой ./gradlew allureReport --depends-on-tests
