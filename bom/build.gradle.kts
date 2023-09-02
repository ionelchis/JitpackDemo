plugins {
    id("java-platform")
    `maven-publish`
}
apply(plugin = "maven-publish")

group = "com.github.ionelchis.JitpackDemo"  // each module that we want to include in the bom
                                            // needs to ba part of the same group, and the group
                                            // should be: com.github.username.projectname
version = "1.1.1"    // define you bom version, this doesn't have to be the same
                    // as the github tag, but it would be helpful to avoid confusion


dependencies.constraints {
    api(project(":lib1"))
    api(project(":lib2"))
}

publishing {
    publications {
        create<MavenPublication>("demoBomPublication") { // add any unique name
            from(components["javaPlatform"])
        }
    }
}