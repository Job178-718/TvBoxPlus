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
    implementation(libs.navigation)
    implementation(libs.hawk)
    implementation(libs.okgo)
    annotationProcessor(libs.room.compiler)
    implementation(libs.room.runtime)
    implementation(libs.nanohttpd)
    implementation(libs.eventbus)
    implementation(libs.juniversalchardet)
    implementation(libs.picasso)
    implementation(libs.okhttp)
    implementation(libs.gson)
//    implementation(libs.autosize)
    implementation(libs.dec)
    implementation(libs.jsoup)
    implementation(libs.xstream) {
        exclude(group = "xmlpull", module = "xmlpull")
    }
    implementation(libs.commons.io)
    implementation(libs.cronet.okhttp)
    implementation(libs.okio)
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar"))))
    //模块导入
    implementation(project(":player"))
    implementation(project(":quickjs"))

}