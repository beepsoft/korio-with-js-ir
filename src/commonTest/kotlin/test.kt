import com.soywiz.korio.async.suspendTest
import com.soywiz.korio.file.std.uniVfs
import kotlin.test.Test

class KorioTest {

    // Run in JVM: OK
    // Run in JS with LEGACY: OK
    // Run in JS with IR:
    // e: .../MPPLib/src/commonTest/kotlin/test.kt: (1, 8): Unresolved reference: com
    // e: .../MPPLib/srsc/commonTest/kotlin/test.kt: (2, 8): Unresolved reference: com
    // e: .../MPPLib/src/commonTest/kotlin/test.kt: (8, 33): Unresolved reference: suspendTest
    // e: .../MPPLib/src/commonTest/kotlin/test.kt: (9, 27): Unresolved reference: uniVfs
    // see build.gradle.kts
    @Test
    fun korioWorkInJSAndJVM() = suspendTest {
        val file = "./".uniVfs
        println("Current directory: ${file.absolutePath}")
    }

}