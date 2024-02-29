plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")  //обработка аннотаций
}

android {
    namespace = "com.BySandS.testssndquizes"
    compileSdk = 34

    defaultConfig {
        minSdk = 30

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
    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
    }
}

dependencies {
    implementation ("androidx.room:room-runtime:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1") // Кодогенератор
    implementation ("androidx.room:room-ktx:2.6.1") // Дополнительно для Kotlin Coroutines, Kotlin Flows

    implementation (project (":domain"))

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    //espresso тоже можно удалить
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}