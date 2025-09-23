plugins {
    kotlin("jvm") version "1.9.20"
}

group = "org.example"
version = "1.0-SNAPSHOT"

val shiratesCoreVersion = "8.6.4"
val appiumClientVersion = "9.4.0"

val userHome = System.getProperty("user.home")

repositories {
    mavenCentral()

    maven(url = "file:/$userHome/.m2/repository")
}

dependencies {

    // JUnit 5
    implementation("org.junit.jupiter:junit-jupiter-api:5.10.5")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.5")

    // shirates-core
    testImplementation("io.github.ldi-github:shirates-core:$shiratesCoreVersion")

    // Appium
    testImplementation("io.appium:java-client:$appiumClientVersion")

    // Apache Commons IO
    testImplementation("commons-io:commons-io:2.18.0")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}