import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

repositories {
    mavenCentral()
}

plugins {
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.springframework.boot") version "2.4.4"
    kotlin("jvm") version "1.4.31"
    kotlin("plugin.spring") version "1.4.31"
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

subprojects {
    repositories {
        mavenCentral()
    }

    apply {
        plugin("idea")
        plugin("java-library")
        plugin("kotlin")
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
        plugin("org.jetbrains.kotlin.plugin.spring")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.kapt")
    }

    dependencyManagement {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:2.4.4")
        }
        dependencies {
            dependency("io.kotest:kotest-runner-junit5:4.3.1")
            dependency("io.kotest:kotest-assertions-json:4.3.1")
            dependency("io.kotest:kotest-assertions-core:4.3.1")
            dependency("io.kotest:kotest-property:4.3.1")
            dependency("io.kotest:kotest-extensions-spring:4.3.1")
            dependency("io.mockk:mockk:1.10.2")
        }
    }

    dependencies {
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        // logger
        implementation("io.github.microutils:kotlin-logging-jvm:2.0.2")

        // test
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("io.mockk:mockk:1.10.2")

        testImplementation("io.kotest:kotest-runner-junit5:4.4.3")
        testImplementation("io.kotest:kotest-extensions-spring:4.4.3")
    }

    configurations {
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    this.apply {
        // integration test 설정
        sourceSets {
            create("integration-test") {
                compileClasspath += sourceSets.main.get().output + sourceSets.test.get().output
                runtimeClasspath += sourceSets.main.get().output + sourceSets.test.get().output

                resources.srcDir(file("src/integration-test/resources"))
            }
        }

        val integrationTestImplementation by configurations.getting {
            extendsFrom(configurations.implementation.get(), configurations.testImplementation.get())
        }

        val integrationTestRuntimeOnly by configurations.getting {
            (configurations.testRuntimeOnly.get())
        }
    }
}

tasks.jar { enabled = true }
tasks.bootJar { enabled = false }
