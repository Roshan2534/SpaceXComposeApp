import org.gradle.api.artifacts.dsl.DependencyHandler

infix fun DependencyHandler.annotate(list: List<String>) {
    list.forEach { dependency ->
        add("annotationProcessor", dependency)
    }
}

infix fun DependencyHandler.dependent(dependencies: List<String>) {
    dependencies.forEach {
        add("classpath", it)
    }
}

infix fun DependencyHandler.need(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

infix fun DependencyHandler.ksp(list: List<String>) {
    list.forEach { dependency ->
        add("ksp", dependency)
    }
}

infix fun DependencyHandler.androidTest(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

infix fun DependencyHandler.debug(list: List<String>) {
    list.forEach { dependency ->
        add("debugImplementation", dependency)
    }
}

infix fun DependencyHandler.test(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}