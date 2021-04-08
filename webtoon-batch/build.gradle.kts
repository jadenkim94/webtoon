dependencies {
    implementation(project(":webtoon-core"))
}
tasks.jar {
    enabled = true
    archiveClassifier.set("library")
}

tasks.bootJar {
    enabled = true
    mainClass.set("com.depromeet.webtoon.batch.WebToonBatchApplication")
    archiveFileName.set("webtoon-batch.jar")
}
