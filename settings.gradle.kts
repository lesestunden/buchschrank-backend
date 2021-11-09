pluginManagement {
	repositories {
		maven { url = uri("https://repo.spring.io/release") }
		maven { url = uri("https://repo.spring.io/snapshot") }
		maven { url = uri("https://repo.spring.io/milestone") }
		gradlePluginPortal()
	}
}
rootProject.name = "buchschrank"
