dependencies {
    implementation(project(":webtoon-core"))
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    implementation("org.springframework.boot:spring-boot-starter-web")

    integrationTestImplementation("com.h2database:h2")
}

tasks.jar {
    enabled = true
    archiveClassifier.set("library")
}

tasks.bootJar {
    enabled = true
    mainClassName = "com.depromeet.webtoon.api.WebtoonApiApplication"
    archiveFileName.set("webtoon-api.jar")
}
