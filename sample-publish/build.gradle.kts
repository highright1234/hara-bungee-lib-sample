plugins {
    `maven-publish`
    signing
}

val apis = allprojects.filter { it.name.endsWith("api") }
fun String.publicationName(): String = removePrefix("${rootProject.name}-")

tasks {
    javadoc {
        options.encoding = "UTF-8"
    }

    create<Jar>("sourcesJar") {
        archiveClassifier.set("sources")
        from(sourceSets["main"].allSource)
    }

    create<Jar>("javadocJar") {
        archiveClassifier.set("javadoc")
        dependsOn("dokkaHtml")
        from("$buildDir/dokka/html")
    }
}

publishing {
    repositories {
        mavenLocal()
        maven {
            name = "MavenCentral"

            credentials {
                val ossrhUsername: String by project
                val ossrhPassword: String by project
                username = ossrhUsername
                password = ossrhPassword
            }

            val releasesRepoUrl = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
            val snapshotsRepoUrl = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
            url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)
        }
    }

    publications {
        apis.forEach {
            create<MavenPublication>(it.name) {
                artifactId = it.name
                from(it.components["java"])
                artifact(it.tasks["sourcesJar"])
                artifact(it.tasks["javadocJar"])

                pom {
                    name.set(it.name.removePrefix("${rootProject.name}-"))
                    description.set("Api of ${it.name.publicationName()}")
                    url.set("https://github.com/highright1234/${rootProject.name}")
                    licenses {
                        license {
                            name.set("GNU General Public License version 3")
                            url.set("https://opensource.org/licenses/GPL-3.0")
                        }
                    }

                    developers {
                        developer {
                            id.set("highright1234")
                            name.set("HighRight")
                            email.set("highright1234@gmail.com")
                            url.set("https://github.com/highright1234")
                        }
                    }

                    scm {
                        connection.set("scm:git:git://github.com/highright1234/${rootProject.name}.git")
                        developerConnection.set("scm:git:ssh://github.com:highright1234/${rootProject.name}.git")
                        url.set("https://github.com/highright1234/${rootProject.name}")
                    }
                }
            }
        }
    }
}

signing {
    isRequired = true
    sign(publishing.publications)
}