# avaje-jex-static-content issue #1

1. Build & run app.

```shell
mvn clean package &&
java -cp 'target/avaje-jex-static-content-issue-1-1.0-SNAPSHOT.jar:target/libs/*' ru.dmitriybodroff.Main
```

2. Open http://localhost:8080/public/emoji_u1f50d.svg in a **web browser**.

3. We get an error "java.io.IOException: headers already sent" in the log.