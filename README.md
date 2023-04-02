1) На тестовом стенде должены быть установлены Node JS, Java, PostgreSQL, MySQL.
2) Указать в application.properties тестируемую базу данных, а также логин/пароль от БД.
3) Запустить сервис aqa-shop командой java -jar aqa-shop.jar
4) Запустить симулятор npm start
5) Запускаем тесты ./gradlew test -Dselenide.headless=true --info
6) Отчет по тестам Allure запускается командой ./gradlew allureReport --depends-on-tests
