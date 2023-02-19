repositories {
    mavenCentral()
}

dependencies {
    rootProject.allprojects.forEach { project ->
        // 뭔진 모르겠는데 됨
        project
            .configurations
            .compileClasspath.get()
            .allDependencies
            .forEach { testImplementation(it) }
        testImplementation(project)
    }
    testImplementation(kotlin("stdlib-jdk8"))
    testImplementation(kotlin("reflect"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.4.2")
    testImplementation("io.mockk:mockk:1.12.7")
    // https://mvnrepository.com/artifact/org.slf4j/slf4j-simple
    testImplementation("org.slf4j:slf4j-simple:2.0.0")
    testImplementation("junit:junit:4.13.2")
}

//tasks.withType<Test> {
//    useJUnitPlatform()
//}
// 버그남