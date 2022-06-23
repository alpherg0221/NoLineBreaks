import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    id("org.jetbrains.compose") version "1.1.0"
}

group = "jp.gr.java_conf.alpherg0221"
version = "1.0.0"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}

dependencies {
    // compose
    implementation(compose.desktop.currentOs)
    implementation(compose.ui)
    implementation(compose.uiTooling)
    implementation(compose.foundation)
    implementation(compose.material)
    implementation(compose.materialIconsExtended)
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "15"
    kotlinOptions.freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Exe)
            packageName = "NoLineBreaks"
            packageVersion = "1.0.0"
            vendor = "Alpherg"
            includeAllModules = true

            val iconsRoot = project.file("./src/main/resources/icons")
            windows {
                iconFile.set(iconsRoot.resolve("icon.ico"))
            }
        }
    }
}