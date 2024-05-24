# [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)

## Need for Clean Architecture

- Activities, Services, Broadcast Receivers, and Content Providers
    - dependency on Android framework made development a challenge especially for testing

## Clean Principles

- [SOLID](https://www.digitalocean.com/community/conceptual-articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design)
- [Component Cohesion]((https://medium.com/@anca.rebeca/clean-architecture-component-cohesion-principles-8c9722abd9bd))
    - Reuse/Release Equivalence Principle (REP)
        - group classes in a component that can be released together
    - Common Closure Principle (CCP)
        - components should have one reason to change
    - Common Reuse Principle (CRP)
        - component should only have classes that should work together
    - NOTE: principles are conflicting, need to find balance per app requirements

## Layers

- Entity (domain) Layer: objects that hold data and/or business-critical functions
- Use Case Layer: business logic of system
- Interface Adapter Layer: responsible for converting data between frameworks and drivers and use
  case (i.e. ViewModels, presenters, converters, etc.)
- Frameworks and Drivers Layer: outermost layer consisting of Android framework, network, and
  persistence components

## Domain

- No outside dependencies (most stable module)
- Use IoC via abstractions to keep its independence
- No knowledge of how anything in the outside world works
    - i.e. JSON, GSON, XML, etc.
    - entities should be clean with no attributes or annotations

```
data class User(
    val id: Int,
    val name: String,
    val email: String
)
```

```
interface UserRepository {
    fun getUsers(): Flow<List<User>>
    suspend fun getUser(id: Int): User
}
```
