#Library cheatsheet

This readme file helpful to add dependency in project.

## Retrofit

```
implementation ('com.squareup.retrofit2:converter-scalars:2.11.0')
implementation ('com.squareup.retrofit2:retrofit:2.11.0')
implementation ('com.squareup.retrofit2:converter-gson:2.11.0')
implementation ('com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.14')
implementation ('com.squareup.okhttp3:okhttp:5.0.0-alpha.14')
```

## Timber
```
implementation ('com.jakewharton.timber:timber:5.0.1')
```

## Room
```
implementation("androidx.room:room-runtime:2.7.0")
kapt("androidx.room:room-compiler:2.7.0")
implementation("androidx.room:room-ktx:2.7.0")
```

## Hilt

```
implementation('com.google.dagger:hilt-android:2.56')
kapt("com.google.dagger:hilt-android-compiler:2.56")
implementation('androidx.hilt:hilt-navigation-compose:1.2.0')
kapt(''androidx.hilt:hilt-compiler:1.2.0'')
```

## Testing
```
testImplementation(libs.junit)
androidTestImplementation(libs.androidx.junit)
testImplementation(libs.mockk.android)
testImplementation(libs.kotlin.coroutine.test)
testImplementation(libs.turbine.test)
```
