package yandex.practicum.conventionsample.build_logic.convention

import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

fun DependencyHandler.library(name: String) =
    extensions.getByType<VersionCatalogsExtension>().named("libs").findLibrary(name)
//fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
//    add("implementation", dependencyNotation)

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")
            pluginManager.apply("org.jetbrains.kotlin.android")

            extensions.configure<LibraryExtension> {
                compileSdk = 35
                defaultConfig {
                    minSdk = 24
                    targetSdk = 35
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }
                buildFeatures {
                    compose = true
                }

//                composeOptions {
//                    kotlinCompilerExtensionVersion =
//                        libs.findVersion("androidxComposeCompiler").get().toString()
//                }
            }
            extensions.configure<KotlinAndroidProjectExtension> {
                compilerOptions {
                    jvmTarget = JvmTarget.JVM_17
                }
            }

            dependencies {
                add("implementation", platform(library("androidx.compose.bom")))
                add("implementation", library("androidx.compose.material3"))
//                add("implementation", library("androidx-appcompat"))

                add("implementation", project(":core:analytics"))
            }
        }
    }
}
