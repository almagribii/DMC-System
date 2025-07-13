plugins {
    id("java")
    id("application")
}

application{
    mainClass = "org.demo.DmcApp"
}

group = "org.demo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("org.mongodb:mongodb-driver-sync:4.11.1")
    implementation ("org.slf4j:slf4j-api:1.7.36")
    runtimeOnly ("ch.qos.logback:logback-classic:1.2.11")
}

tasks.test {
    useJUnitPlatform()
}