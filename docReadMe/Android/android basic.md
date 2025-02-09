# Android Basic

## Android SDK
Android SDK (Software development kit) is a collection of library that developers use to create application for the android.
Key component
   - <b>SDK Tools</b>
       - <b>ADB (Android Debug Bridge)</b> is command tool that help to interact with emulator or connected device.
       - <b>Fastboot</b> is help to flash images on device.
       - <b>Emulator</b> is virtual device which help to run android in laptop on which we can test application
   - <b>Platform tools</b> packages that contain the APIs and libraries for specific android versions.

## Android Component
Android applications are built using four main components, which manage the app’s UI, background processes, and data handling.

- Activity
- Service
- Broadcast Receiver
- Content provider

## Manifest
Manifest is configuration file for an android app. This describes main information about the app that include
  - Package name
  - Permissions
  - App icon & name
  - Activities
  - Services
  - Broadcast Receiver

## Context
Context is the interface that contain global information about application environment. This help to access application specific resources (strings, color, drawables), starting activity, service, broadcast.

## Application Context
Application Context This type of context is directly related with life cycle of application. You can access it via getApplicationContext().

## Activity

Activity is main component of an app that represents a single screen with user interface. It acts as user entry point for user interaction
and contains ui element like button, text, list and more. </br>
Activity has own lifecycle.

 1. `onCreate(saveInstanceState: Bundle?)` Called only once when activity is created and used for initializing components
 2. `onStart()` Called when activity becomes visible to user
 3. `onResume()` Called when activity starts intracting with user. 
 4. `onPause()` Called when activity is partially obsecured like showing dialog over activity
 5. `onStop()` Called when activity is no longer visible.
 6. `onDestroy()` Called before activity is destroyed. User to clean up resource to prevent from memory leak.

We have few other method that would help based on requirement. onNewIntent(), onRestart(), onSaveInstance(), onRestoreInstance()

## Fragment

Fragment is reusable and modular ui component that represent a portion of a screen in an activity. Fragments are useful for building ui for tablet and large screen

**Key point**
- Can be `add`, `remove`, and `replace` dynamically
- Has its own lifecycle but dependent on activity
- Support multiple fragment in one activity.

**Lifecycle method**

 - `onAttach()` Called when fragment attached to an activity
 - `onCreate()` Called when fragment initialized
 - `onCreateView()` 
 - `onViewCreated()`
 - `onStart()`
 - `onResume()`
 - `onPause()`
 - `onStop()`
 - `onDestroyView()`
 - `onDestroy()`
 - `onDetach()`

## Intent
Intent is a messaging object, used to communicate with application component or with different application.
   - `Implicit Intent` is used to request an action without specifying the target app. The system determines which app can handle the request
**Open a Website in Browser** 
```
val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
startActivity(intent)
```

**Send an email**

```
val intent = Intent(Intent.ACTION_SENDTO)
intent.data = Uri.parse("mailto:example@gmail.com")
intent.putExtra(Intent.EXTRA_SUBJECT, "Hello!")
intent.putExtra(Intent.EXTRA_TEXT, "How are you?")
startActivity(intent)
```

- `Explict Intent` is used to launch a specific activity within the same app. You define the target activity directly.

```
val intent = Intent(this, SecondActivity::class.java)
startActivity(intent)
```
## Broadcast Receiver
Broadcast Receiver in Android is a component that allows applications to receive and handle broadcast messages from the Android system or other applications. These messages, or broadcasts, are sent when an event occurs, such as the device charging, network changes, or custom application-defined events.
  - We can register brodcast from manifest(implicit register) or by registering from activity, fragment & services (exclicit).
  - Implicit registed will not work if android OS version >= 26 except few [intent action](https://developer.android.com/develop/background-work/background-tasks/broadcasts/broadcast-exceptions)
