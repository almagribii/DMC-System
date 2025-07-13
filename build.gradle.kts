plugins {
    id("java")
    id("application")
    id("io.spring.dependency-management") version "1.1.7"
    id("org.springframework.boot") version "3.3.1"
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
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")

}

tasks.test {
    useJUnitPlatform()
}