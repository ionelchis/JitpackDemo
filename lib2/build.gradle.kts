plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    `maven-publish`
}
apply(plugin = "maven-publish")

group = "com.github.ionelchis"
version = "1.0.8"

android {
    namespace = "com.ionelchis.lib2"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
            }
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

dependencies.constraints {
    // Android core dependencies
    api("androidx.core:core-ktx:1.10.1")
    api ("androidx.appcompat:appcompat:1.6.1")
    api ("androidx.activity:activity-ktx:1.7.2")
    api ("androidx.fragment:fragment-ktx:1.6.1")
    api ("com.jakewharton.timber:timber:5.0.1")

    // Android ui dependencies
    api ("com.google.android.material:material:1.9.0")
    api ("androidx.constraintlayout:constraintlayout:2.1.4")
    api ("com.github.bumptech.glide:glide:4.16.0")
}