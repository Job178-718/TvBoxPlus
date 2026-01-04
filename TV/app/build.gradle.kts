import org.gradle.internal.impldep.bsh.commands.dir

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.tv"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.tv"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        // 在 compileOptions 之后添加
        javaCompileOptions {
            annotationProcessorOptions {
                arguments += mapOf("room.schemaLocation" to "$projectDir/schemas")
            }
        }
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    //noinspection UseTomlInstead,GradleDependency
    implementation("androidx.navigation:navigation-compose:2.8.9")
    implementation("com.orhanobut:hawk:2.0.1")
    implementation("com.lzy.net:okgo:3.0.4")
    annotationProcessor("androidx.room:room-compiler:2.3.0")
    implementation("androidx.room:room-runtime:2.3.0")
    implementation("org.nanohttpd:nanohttpd:2.3.1")
    implementation("org.greenrobot:eventbus:3.2.0")
    // 添加字符集检测库
    implementation("com.github.albfernandez:juniversalchardet:2.4.0")
    implementation("com.squareup.picasso:picasso:2.71828")
    // 添加 DNS over HTTPS 支持
    implementation("com.squareup.okhttp3:okhttp:3.12.11")
    implementation("com.google.code.gson:gson:2.8.7")
    implementation("me.jessyan:autosize:1.2.1")
    implementation("org.brotli:dec:0.1.2")
    implementation("org.jsoup:jsoup:1.14.1")
    implementation("com.thoughtworks.xstream:xstream:1.4.15") {
        exclude(group = "xmlpull", module = "xmlpull")
    }
    implementation("commons-io:commons-io:2.11.0")
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))
    implementation("com.google.net.cronet:cronet-okhttp:0.1.0")
    implementation("com.squareup.okio:okio:2.8.0")
    //模块导入
    implementation(project(":player"))
    implementation(project(":quickjs"))

}