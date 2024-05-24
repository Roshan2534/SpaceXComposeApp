object AppDependencies {
    // classpath
    private val crashlytics by lazy { "com.google.firebase:firebase-crashlytics-gradle:${Version.crashlytics}" }
    private val gradle by lazy { "com.android.tools.build:gradle:${Version.gradle}" }
    private val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}" }
    private val hilt by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Version.dagger}" }
    private val googleServices by lazy { "com.google.gms:google-services:${Version.googleServices}" }
    private val ksp by lazy { "com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:${Version.ksp}" }

    // activity
    private val activityCompose by lazy { "androidx.activity:activity-compose:${Version.activityCompose}" }
    // coil
    private val coliCompose by lazy { "io.coil-kt:coil-compose:${Version.coil}" }
    // compose
    private val composeUi by lazy { "androidx.compose.ui:ui:${Version.compose}" }
    private val composeUiGraphics by lazy { "androidx.compose.ui:ui-graphics:${Version.compose}" }
    private val material3 by lazy { "androidx.compose.material3:material3:${Version.material3}" }
    private val toolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Version.compose}" }
    // core
    private val coreKtx by lazy { "androidx.core:core-ktx:${Version.core}" }
    private val coroutinesAndroid by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}" }
    // di
    private val hiltAndroid by lazy { "com.google.dagger:hilt-android:${Version.dagger}" }
    // firebase
    private val analyticsKtx by lazy { "com.google.firebase:firebase-analytics-ktx:${Version.analyticsKtx}" }
    private val authKtx by lazy { "com.google.firebase:firebase-auth-ktx:${Version.authKtx}" }
    private val crashlyticsKtx by lazy { "com.google.firebase:firebase-crashlytics-ktx:${Version.crashlyticsKtx}" }
    // nav
    private val hiltNavCompose by lazy { "androidx.hilt:hilt-navigation-compose:${Version.hiltNavCompose}" }
    private val navigationCompose by lazy { "androidx.navigation:navigation-compose:${Version.navCompose}" }
    // network
    private val converterGson by lazy { "com.squareup.retrofit2:converter-gson:${Version.retrofit}" }
    private val gson by lazy { "com.google.code.gson:gson:${Version.gson}" }
    private val interceptor by lazy { "com.squareup.okhttp3:logging-interceptor:${Version.okhttp}" }
    private val okhttp by lazy { "com.squareup.okhttp3:okhttp:${Version.okhttp}" }
    private val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Version.retrofit}" }
    // room
    private val roomRuntime by lazy { "androidx.room:room-runtime:${Version.room}" }
    private val roomKtx by lazy { "androidx.room:room-ktx:${Version.room}" }

    // ksp compilers
    private val hiltCompiler by lazy { "com.google.dagger:hilt-compiler:${Version.dagger}" }
    private val roomCompiler by lazy { "androidx.room:room-compiler:${Version.room}" }

    // android
    private val testJunit by lazy { "androidx.compose.ui:ui-test-junit4:${Version.compose}" }
    private val extJunit by lazy { "androidx.test.ext:junit:${Version.extJunit}" }
    private val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Version.espressoCore}" }
    // debug
    private val uiTooling by lazy { "androidx.compose.ui:ui-tooling:${Version.compose}" }
    private val testManifest by lazy { "androidx.compose.ui:ui-test-manifest:${Version.compose}" }
    // test
    private val junit by lazy { "junit:junit:${Version.junit}" }
    private val mockitoKotlin by lazy { "org.mockito.kotlin:mockito-kotlin:${Version.mockito}" }
    private val coroutinesTest by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutines}" }

    // classpath
    val dependency = arrayListOf<String>().apply {
        add(crashlytics)
        add(gradle)
        add(kotlin)
        add(hilt)
        add(googleServices)
        add(ksp)
    }

    // implementation
    val activity = arrayListOf<String>().apply {
        add(activityCompose)
    }
    val coil = arrayListOf<String>().apply {
        add(coliCompose)
    }
    val compose = arrayListOf<String>().apply {
        add(composeUi)
        add(composeUiGraphics)
        add(material3)
        add(toolingPreview)
    }
    val core = arrayListOf<String>().apply {
        add(coreKtx)
        add(coroutinesAndroid)
    }
    val di = arrayListOf<String>().apply {
        add(hiltAndroid)
    }
    val firebase = arrayListOf<String>().apply {
        add(analyticsKtx)
        add(authKtx)
        add(crashlyticsKtx)
    }
    val hiltNav = arrayListOf<String>().apply {
        add(hiltNavCompose)
    }
    val nav = arrayListOf<String>().apply {
        add(navigationCompose)
    }
    val network = arrayListOf<String>().apply {
        add(converterGson)
        add(gson)
        add(interceptor)
        add(okhttp)
        add(retrofit)
    }
    val room = arrayListOf<String>().apply {
        add(roomRuntime)
        add(roomKtx)
    }

    // ksp compilers
    val kspHiltCompiler = arrayListOf<String>().apply {
        add(hiltCompiler)
    }
    val kspRoomCompiler = arrayListOf<String>().apply {
        add(roomCompiler)
    }

    // debug/test
    val androidTest = arrayListOf<String>().apply {
        add(testJunit)
        add(extJunit)
        add(espressoCore)
    }
    val debug = arrayListOf<String>().apply {
        add(uiTooling)
        add(testManifest)
    }
    val test = arrayListOf<String>().apply {
        add(junit)
        add(mockitoKotlin)
        add(coroutinesTest)
    }
}