# Code & data security


## Progurad/R8
Proguard/R8 is tool in android, help to shrink, obfuscate and optimize code so that app size can reduce, prevent from reverse engineering

- **Shrink:** Remove unused code and resource
- **Obfuscate:** Renames code to make it smaller and secure
- **Optimize code:** Improves bytecode efficiency
- **desugaring:** Convert code in such way that code would work for older version.


```
-keep [modifiers] class qualified.name { members; }
```

**Optimization**
```
// Code
public int add() {
    return 2 + 2;
}

// Proguard/ R8
public int add() {
    return 4;
}
```

**Desugaring**

```
// Code
List<String> list = Arrays.asList("a", "b", "c");
list.forEach(item -> Log.d("Item", item));

// Proguard/ R8
for (String item : list) {
    Log.d("Item", item);
}
```

| Feature | ProGuard | R8 |
| :--- | :--- | :--- |
| **Included by default** | (used to be, now optional) | Yes, from Android Studio 3.4+ |
| **Introduced by** | Guardsquare | Google |
| **Optimizes code** | Yes | Yes (better & faster) |
| **Obfuscates code** | Yes | Yes |
| **Shrinks unused code** | Yes | Yes (more aggressive) |
| **Supports Java 8+ desugaring** | Yes but Needs extra tools | Built-in |
| **Configuration format** | ProGuard syntax | Same syntax |
| **Speed** | Slower| Faster |

Common ProGuard Rules

- Keep all classes in a package (no obfuscation or shrinking):

```
-keep class com.example.myapp.** { *; }
```

- Keep a specific class and all its members:

```
-keep class com.example.myapp.MyClass { *; }
```

- Keep a class but allow its methods to be obfuscated:

```
-keepclassmembers class com.example.myapp.MyClass { *; }

```

- Keep model classes used with Gson or other serialization libraries:

```
-keep class com.example.myapp.model.** { *; }
-keepclassmembers class * {
    @com.google.gson.annotations.SerializedName <fields>;
}
```

| File Name| What It Shows | Why It is Useful |
| :--- | :--- | :--- |
| mapping.txt | Obfuscated names mapping | For de-obfuscating crash logs |
| usage.txt | Code that was removed | For checking what's eliminated |
| seeds.txt | Code that was retained| For understanding keep rules impact |
| whyareyoukeeping.txt| Explanation of why something wasn't removed | For advanced debugging and rule fine-tuning |

These files generated when we run release command.


- Certificate pining
- data encryption, decryption alogrithm
