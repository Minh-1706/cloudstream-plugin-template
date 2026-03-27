plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    compileSdk = 34
    namespace = "com.example"

    defaultConfig {
        minSdk = 21
    }
}

dependencies {
    val cloudstreamVersion = "3.0.0" 
    compileOnly("com.lagradost:cloudstream3:$cloudstreamVersion")
    implementation("com.github.Blatzar:NiceHttp:0.4.9")
    implementation("org.jsoup:jsoup:1.16.1")
}
