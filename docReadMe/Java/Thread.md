## Thread

Thread is the smallest unit of processes which executes independently within the program, JVM allows an application that can excute multiple threads concurrently.
There are 2 methods we can create threads in Java.

 - **By extending thread class**
```
public class ThreadExample extends Thread {
    public static void main(String args[]) {
        ThreadExample threadExample = new ThreadExample();
        threadExample.start();
    }
public void run() {
  System.out.println(Thread.currentThread().getName() + "Started");
    }
}
```

- **By implementing runnable Interface**

```
public class ThreadExample implements Runnable {
    public static void main(String args[]) {
        ThreadExample threadExample = new ThreadExample();
        Thread thread = new Thread(threadExample);
        thread.start();
    }
@Override
    public void run() {
   System.out.println(Thread.currentThread().getName() + "Started");
    }
}
```
