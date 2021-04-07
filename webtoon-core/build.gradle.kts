dependencies {
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("org.springframework.boot:spring-boot-starter-validation")

    runtimeOnly("com.h2database:h2")
}

tasks.jar { enabled = true }
tasks.bootJar { enabled = false }
