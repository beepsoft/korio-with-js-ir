# [korio](https://github.com/korlibs/korio) doesn't work with js(IR)

1. Run korioWorkInJSAndJVM with JVM target: it works
2. Run korioWorkInJSAndJVM with JS target: it fails with
```
e: .../src/commonTest/kotlin/test.kt: (1, 8): Unresolved reference: com
e: .../srsc/commonTest/kotlin/test.kt: (2, 8): Unresolved reference: com
e: .../src/commonTest/kotlin/test.kt: (8, 33): Unresolved reference: suspendTest
e: .../src/commonTest/kotlin/test.kt: (9, 27): Unresolved reference: uniVfs
```
3. Change in build.gradle.kts `js(IR)` to `js(LEGACY)`
4. Run korioWorkInJSAndJVM with JS target: it works.

