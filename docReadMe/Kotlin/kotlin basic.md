# Kotlin basic

Kotlin is a language which is introduced by ![Jetbrains](https://kotlinlang.org/docs/getting-started.html) in July 22, 2011. With the help of Kotlin, We can develop **Android** app, **multi plateform application**.

<br><img src = "https://kotlinlang.org/_next/static/chunks/images/multiplatform-preview-7b3351f5847838b3eed177968632b081.svg" />

## var
`var` keyword is used to define mutable variable. It means when we need to change variable value after initialization. 

**syntax:** `var variableName: Type`

```
var name: String = "Neeraj"
name = "kumar"
var age: Int
```

## val
`val` keyword is used to define read-only / immutable variable, means variable value can't change after initialization.

**syntax:** `val variableName: Type`

```
val name: String = "Neeraj"
name = "kumar" // we will get syntax issue in this line
```
## null safety
In Kotlin, null safety is a key feature that helps to prevent from `NullPointerException`. kotlin differentiates between nullable and non-nullable types to enforce safe handling of null values.

- **Non Nullable (String)** can't be assigned null value to variable.
- **Nullable (String?)** can hold null value.

```
var nonNullableVariable: String = "Hello"
nonNullableVariable = null // Compilation error

var nullableVariable: String? = "Hello"
nullableVariable = null // Allowed
```
- **Safe call (?.)** Used to safely access properties or call function on nullable types

```
var nullable: String? = "Hello"
println(nullable?.length)
nullable = null
println(nullable)

## late init
`late init` keyword is used
