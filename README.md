to run test that won't crash:
```
./gradlew  -Dtest.single=NotCrashTest test
```

to run test that will crash:
```
./gradlew  -Dtest.single=CrashTest test
```