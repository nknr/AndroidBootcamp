#AndroidBootcamp

**Broadcast Receiver** in Android is a component that allows applications to receive and handle broadcast messages from the Android system or other applications. These messages, or broadcasts, are sent when an event occurs, such as the device charging, network changes, or custom application-defined events.
- We can register brodcast from manifest(implicit register) or by registering from activity, fragment & services (exclicit).
- Implicit registed will not work if android OS version >= 26 except few [intent action](https://developer.android.com/develop/background-work/background-tasks/broadcasts/broadcast-exceptions)
