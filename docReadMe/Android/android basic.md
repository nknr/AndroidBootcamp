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

## Launch Mode
Launch Modes define how an activity is launched and how it interacts with the back stack. They determine whether a new instance of an activity should be created or an existing one should be reused. There are four launch modes

   1. `standard`
   2. `singleTop`
   3. `singleTask`
   4. `singleInstance`

- **standard:** 
   - A new instance of the activity is created every time it is launched.
	-  Each instance is added to the task stack.
</br>

```
Start A → Stack: [A]
Start B → Stack: [A, B]
Start A again → Stack: [A, B, A]
Start C → Stack: [A, B, A, C]
```

- **singleTop**
   - If the activity is already on top of the stack, no new instance is created. Instead, onNewIntent() is called.
	- If it’s not on top, a new instance is created.
   
</br>

```
Start A → Stack: [A]
Start B → Stack: [A, B]
Start B again → No new instance (onNewIntent() is called) → Stack: [A, B]
Start C → Stack: [A, B, C]
```

 - **singleTask**
   - A new instance is created if the activity is not in the stack.
	- If it exists anywhere in the stack, Android brings that activity to the foreground and clears all activities above it.
</br>

```  
Start A → Stack: [A]
Start B → Stack: [A, B]
Start C → Stack: [A, B, C]
Start A again → Stack: [A] (Removes B and C, brings A to the top)
```
	
- **singleInstance**
  - Similar to singleTask, but no other activities can be part of its task.
  - If another activity is started, it goes into a separate task.
</br>

```    
Start A → Stack: [A]
Start B → Stack: [A, B]
Start C (singleInstance) → New Task created → [C] (Separate task)
Start D from C → New Task → [C, D]
```
	
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

## Service

Service is a background component that performs long-running operations without a user interface. It is useful for tasks like playing music, handling network operations, performing file I/O, or interacting with databases.

1. `Foreground Service`

   - Runs in the background but remains visible to the user via a **notification**.
   - Used for tasks like **playing music**, **tracking location**, or **handling ongoing network operations**.
   - Requires **FOREGROUND_SERVICE** permission and a notification.

```
class MyForegroundService : Service() {
    override fun onCreate() {
        super.onCreate()
        startForeground(1, createNotification()) // Run in foreground
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    private fun createNotification(): Notification {
        val channelId = "ForegroundServiceChannel"
        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("Foreground Service")
            .setContentText("Running in the background")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()
        return notification
    }
}

```

2. `Background Service`

   - Runs without a **UI and user interaction**.
   - Used for **syncing data, updating databases, or downloading files**.
   - Since **Android 8 (Oreo)**, background services have strict restrictions.

```
class MyBackgroundService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // Perform background task
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
```

3. `Bound Service`

   - A client-server model where multiple components bind to a service.
   - The service **dies** when no clients are bound.
   - Used for real-time interactions (e.g., music players, data fetching).

```
class MyBoundService : Service() {
    private val binder = LocalBinder()

    inner class LocalBinder : Binder() {
        fun getService(): MyBoundService = this@MyBoundService
    }

    override fun onBind(intent: Intent?): IBinder {
        return binder
    }

    fun getData(): String {
        return "Bound Service Data"
    }
}

```

**Lifecycle Methods of Service**

| Method | Description |
| :---: | :-- |
| onCreate() | Called when the service is created. |
| onStartCommand() |	Handles start requests from other components. |
| onBind() | Returns an IBinder for bound services. |
| onUnbind() | Called when all clients have unbound. |
| onDestroy()| Called when the service is destroyed. |

**Service Execution Modes**

| Execution Mode | Description |
| :---: | :--- |
| `START_NOT_STICKY` | The service is not restarted if killed. |
| `START_STICKY` | The service is restarted but intent is null. |
| `START_REDELIVER_INTENT` |	The service is restarted and receives the last intent. |

## Broadcast Receiver
Broadcast Receiver in Android is a component that allows applications to receive and handle broadcast messages from the Android system or other applications. These messages, or broadcasts, are sent when an event occurs, such as the device charging, network changes, or custom application-defined events.
  - We can register brodcast from manifest(implicit register) or by registering from activity, fragment & services (exclicit).
  - Implicit registed will not work if android OS version >= 26 except few [intent action](https://developer.android.com/develop/background-work/background-tasks/broadcasts/broadcast-exceptions)
