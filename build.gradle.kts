buildscript {
    val kotlinVersion = "1.5.21"
    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

allprojects {
    repositories {
        mavenCentral()
        google()
        maven { url = uri("https://jitpack.io") }
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots/") }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
