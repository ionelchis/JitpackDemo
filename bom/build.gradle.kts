plugins {
    id("java-platform")
    `maven-publish`
}
apply(plugin = "maven-publish")

group = "com.github.ionelchis"
version = "1.0.4"

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("mavenJava") {
                from(components["javaPlatform"])
            }
        }
    }
}

dependencies.constraints {
    api(project(":lib1"))
    api(project(":lib2"))
}