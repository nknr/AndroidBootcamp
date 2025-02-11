# Kotlin Flow

A suspending function asynchronously returns a single value, but when we require multiple value asynchronously then how can we do? then It **kotlin flow** comes in this synario

Kotlin Flow is a reactive stream API introduced in Kotlin Coroutines to handle asynchronous data streams. It is designed to work seamlessly with suspend functions and coroutines while avoiding callback

## What is Flow?
Flow is a cold stream that emits multiple values sequentially. Flow can return multiple values over time.

**Key Features of Flow:**

- **Cold Stream:** It starts executing only when a collector is present.
- **Asynchronous:** Works with coroutines.
- **Backpressure Handling:** Uses suspension instead of blocking the thread.
- **Cancellation Support:** Gets canceled when the coroutine scope is canceled.

```
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

               
fun simple(): Flow<Int> = flow { // flow builder
    for (i in 1..3) {
        delay(100) // pretend we are doing something useful here
        emit(i) // emit next value
    }
}

fun main() = runBlocking<Unit> {
    // Launch a concurrent coroutine to check if the main thread is blocked
    launch {
        for (k in 1..3) {
            println("I'm not blocked $k")
            delay(100)
        }
    }
    // Collect the flow
    simple().collect { value -> println(value) } 
}
```
![Run in playground](https://pl.kotl.in/SFoGzim1a)

## Cold vs. Hot Streams
| Cold Stream | Hot stream |
| :--- | :--- |
| Producer only emit data when collector present | producer will emit data without having (**StateFlow, ShareFlow**) |
| Data on demand | Broadcast, Radio |

## Intermediate Operators in Flow
Intermediate operators modify the data before passing it to collectors.

| Operator | Description |
| :--- | :--- |
| `map {}` | Transforms each emitted value. |
| `filter {}` |	Filters values based on a condition. |
| `take(n)` |	Takes only the first n values. |
| `transform {}` |	Emits multiple values per input. |
| `flatMapConcat {}` |	Flattens multiple flows into a single flow sequentially. |
| `flatMapMerge {}` |	Flattens multiple flows concurrently. |

## Terminal Operators in Flow
Terminal operators collect data from Flow and trigger execution.

| Operator | Description |
| :--- | :--- |
| `collect {}` |	Collects emitted values. |
| `toList()` |	Collects flow values into a list. |
| `first()` |	Takes the first emitted value. |
| `single()` |	Ensures only a single value is emitted. |
| `reduce {}` |	Reduces values to a single result. |
| `fold(initial) {}` |	Accumulates values with an initial value. |

## Important operator need to cover

- flowOn()
- buffer()
- conflate()
- catch()
- completion

**Reference**
- ![Official doc](https://kotlinlang.org/docs/flow.html#successful-completion)
