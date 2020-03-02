# FIT
UserDoc
Существует список пользователей. У каждого пользователя может быть список его документов. С помощью реализованого RESTfull интерфейса можно выполнять следующие действия: 
-создавать, редактировать и удалять пользователей
-добавлять пользователю с известным id документ
-получить все документы пользователя, у которых срок действия еще не закончился

Настройка проекта
В файле docuser/src/main/resources/ application.properties необходимо указать подключение к базам данных.
Для Postgres:
spring.datasource.url=jdbc:postgresql://localhost:5432/userdoc 	
spring.datasource.username=postgres
spring.datasource.password=123
Для Mongo:
spring.data.mongodb.database=test_db
spring.data.mongodb.port=27017
spring.data.mongodb.host=localhost

