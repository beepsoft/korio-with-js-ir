plugins {
    kotlin("multiplatform") version "1.4.31"
}

group = "beepsoft.mpp.test"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://dl.bintray.com/korlibs/korlibs/")
}


kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        testRuns["test"].executionTask.configure {
            useJUnit()
        }
    }
    // With LEGACY, it works, with IR it fails with
    // e: .../MPPLib/src/commonTest/kotlin/test.kt: (1, 8): Unresolved reference: com
    // e: .../MPPLib/srsc/commonTest/kotlin/test.kt: (2, 8): Unresolved reference: com
    // e: .../MPPLib/src/commonTest/kotlin/test.kt: (8, 33): Unresolved reference: suspendTest
    // e: .../MPPLib/src/commonTest/kotlin/test.kt: (9, 27): Unresolved reference: uniVfs
    js(IR) {
        nodejs ()
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("com.soywiz.korlibs.korio:korio:1.10.2")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
            }
        }
        val jsMain by getting
        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }
}
