# Code & data security

## Progurad/R8
Proguard/R8 is tool in android that help to shrink, obfuscate and optimize code.
- **Shrink:** Remove unused code and resource
- **Obfuscate:** Renames code to make it smaller and secure
- **Optimize code:** Improves bytecode efficiency
- **desugaring:** Convert code in such way that code would work for older version. 

```
-keep [modifiers] class qualified.name { members; }
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


- Certificate pining
- data encryption, decryption alogrithm
