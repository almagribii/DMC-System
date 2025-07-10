plugins {
    id("java")
}

group = "org.demo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    implementation("org.mongodb:mongodb-driver-sync:4.11.1")
}

tasks.test {
    useJUnitPlatform()
}