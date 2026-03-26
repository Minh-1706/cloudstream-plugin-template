import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.31")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://realsrv.com/repository/public/")
    }
}

subprojects {
    apply(plugin = "com.android.library")
    apply(plugin = "kotlin-android")

    configurations.all {
        resolutionStrategy.eachDependency {
            if (requested.group == "com.github.Blatzar" && requested.name == "NiceHttp") {
                useVersion("0.4.9")
            }
        }
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}
