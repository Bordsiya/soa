# SOA

Бордун Анастасия, Иванов Евгений

## Описание ##

### Сервисы ###
Всего используется 3 сервиса:
- 1 сервис (основной). Spring MVC REST. Tomcat 9.0.80.
- 2 сервис (побочный, обращается к первому). Spring MVC REST. Wildfly 26.1.2.
- 3 сервис (побочный, обращается к первому). JAX-RS. Tomcat 9.0.80.

Почему не новейшие версии?
Для поддержки Jersey. Пока что новейшие версии Tomcat не поддерживают новые версии Jersey, так что нужен downgrade. А так как происходит downgrade по Tomcat, то далее нужен downgrade по spring-boot-starter-parent на версии 2.X.X.

Каждый сервис работает по SSL (self signed certificates):
- 1 сервис (orgdirectory.jks)
- 2 сервис (2service.jks)
- 3 сервис (3service.jks)

### Как деплоить? ###

#### Tomcat ####
application server config - https://drive.google.com/file/d/1U6iXI9mtK0NXiBR493IrIHhvfSg4hJ-M/view?usp=sharing

webapps_13 - настроенная директория для war файлов проекта.
Идем в conf/server.xml и заменяем `keystoreFile="<path>"` на путь до соответсвующего .jks.
Для запуска идем в bin и набираем: catalina.bat run или startup.bat (для Windows).

#### Wildfly ####
application server config - https://drive.google.com/file/d/14ZDJ7J8plF9XXCgZXtx2izsLF7Y85W69/view?usp=sharing

Идем в standalone/configuration/standalone.xml и заменяем:
```xml
<key-store name="service2KS">
      <credential-reference clear-text="2service"/>
      <implementation type="JKS"/>
      <file path="<path>"/>
</key-store>
```

`<file path="<path>"/>` на путь до соответсвующего .jks.
Для запуска идем в bin и запускаем standalone.bat (для Windows).

### Ручки ###
https://localhost:9099/first-service/swagger-ui/index.html#/ - 1 сервис

https://127.0.0.1:9100/swagger-ui/index.html#/ - 2 сервис

https://localhost:9101/organalysis/ - 3 сервис


### Как деплоить frontend?

Весь frontend находится в all-frontend каталоге, для разработки использовать его.

Разработка на node.js так что он должен быть установлен, например с [официального сайта](https://nodejs.org/en/download)

#### Подгрузка необходимых модулей *node*

```sh
npm install
```

#### запуск на локальной машине на порт 5173(или другой)

```sh
npm run dev
```

#### Процесс сборки и деплоя на хелиос
Запускаем следующую команду, чтобы весь фронт положился в dist/ каталог
```sh
npm run build
```
После этого там появится index.html, который будет ссылаться на прочие вещи файлы,
но он ссылается на скрипты как на /assets/... и из-за этого на хелиосе не происходит нормального
чтения этих скриптов, надо поменять путь на ./assets/... Аналогично для всех файлов, которые
использует фронт.

Далее деплоим index.html и assets/ на public_html каталог пользователя на helios.

