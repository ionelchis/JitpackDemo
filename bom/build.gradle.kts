plugins {
    id("java-platform")
    `maven-publish`
}
apply(plugin = "maven-publish")

group = "com.github.ionelchis.JitpackDemo"
version = "1.0.6"


dependencies.constraints {
    api(project(":lib1"))
    api(project(":lib2"))
}

publishing {
    publications {
        create<MavenPublication>("demoBomPublication") {
            from(components["javaPlatform"])
        }
    }
}