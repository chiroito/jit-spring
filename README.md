
# 試す方法

JITコンパイルの状況を MXBean に反映してくれる JitWarmUp が必要です。

```
git clone https://github.com/chiroito/JitWarmUp
cd JitWarmUp
mvn package
mvn install:install-file -Dfile=target/JitWarmUp-1.0-SNAPSHOT.jar -DgroupId=chiroito.sample -DartifactId=JitWarmUp -Dpackaging=jar -Dversion=1.0-SNAPSHOT

git clone https://github.com/chiroito/jit-spring
cd jit-spring
mvn package
java -javaagent:..\JitWarmUp\target\JitWarmUp-1.0-SNAPSHOT.jar -jar jit-spring-0.0.1-SNAPSHOT.jar
```

アプリケーションのパスは `http://localhost:8080/hello` です。ヘルスチェックは `http://localhost:8080/actuator/health` です。