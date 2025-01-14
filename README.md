#AndroidBootcamp

**Android SDK** (Software development kit) is a collection of library that developers use to create application for the android.
Key component
 - <b>SDK Tools</b>
     - <b>ADB (Android Debug Bridge)</b> is command tool that help to interact with emulator or connected device.
     - <b>Fastboot</b> is help to flash images on device.
     - <b>Emulator</b> is virtual device which help to run android in laptop on which we can test application
  - <b>Platform tools</b> packages that contain the APIs and libraries for specific android versions.

 **Activity** is a container in which we add views and user interact with it. This has own lifecycle **onCreate(), onStart(), onResume(), onPause(), onStop(), onDestroy()**. We have few other method that would help based on requirement. onNewIntent(), onRestart(), onSaveInstance(), onRestoreInstance()

**Fragment** is same an activity but this require activity on which fragment can run and help in reusability. This has own lifecycle **onAttach(), onCreate(), onCreateView(), onStart(), onResume(), onPause(), onStop(), onDestroyView(), onDestroy().**

**Intent** is a messaging object, used to communicate with application component or with different application.
 - <b>Implicit Intent</b> is used to communicate with predefined action. Action like opening the webpage, mail, call.
 - <b> Explict Intent</b> is used to communicate within application component like activity, broadcast receiver.

**Broadcast Receiver** in Android is a component that allows applications to receive and handle broadcast messages from the Android system or other applications. These messages, or broadcasts, are sent when an event occurs, such as the device charging, network changes, or custom application-defined events.
- We can register brodcast from manifest(implicit register) or by registering from activity, fragment & services (exclicit).
- Implicit registed will not work if android OS version >= 26 except few [intent action](https://developer.android.com/develop/background-work/background-tasks/broadcasts/broadcast-exceptions)
