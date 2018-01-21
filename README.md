# 线程
## 线程池的5种状态：
#### Running、ShutDown、Stop、Tidying、Terminated。
##### 线程池各个状态切换框架图：
![image](https://note.youdao.com/favicon.ico)
#### 1、RUNNING
> (1) 状态说明：线程池处在RUNNING状态时，能够接收新任务，以及对已添加的任务进行处理。</p> 
> (2) 状态切换：线程池的初始化状态是RUNNING。换句话说，线程池被一旦被创建，就处于RUNNING状态，并且线程池中的任务数为0！

```
private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
```

#### 2、 SHUTDOWN
> (1) 状态说明：线程池处在SHUTDOWN状态时，不接收新任务，但能处理已添加的任务。</p> 
> (2) 状态切换：调用线程池的shutdown()接口时，线程池由RUNNING -> SHUTDOWN。
#### 3、STOP
> (1) 状态说明：线程池处在STOP状态时，不接收新任务，不处理已添加的任务，并且会中断正在处理的任务。 </p>
> (2) 状态切换：调用线程池的shutdownNow()接口时，线程池由(RUNNING or SHUTDOWN ) -> STOP。
#### 4、TIDYING
> (1) 状态说明：当所有的任务已终止，ctl记录的”任务数量”为0，线程池会变为TIDYING状态。当线程池变为TIDYING状态时，会执行钩子函数terminated()。terminated()在ThreadPoolExecutor类中是空的，若用户想在线程池变为TIDYING时，进行相应的处理；可以通过重载terminated()函数来实现。 </p>
> (2) 状态切换：当线程池在SHUTDOWN状态下，阻塞队列为空并且线程池中执行的任务也为空时，就会由 SHUTDOWN -> TIDYING。 
当线程池在STOP状态下，线程池中执行的任务为空时，就会由STOP -> TIDYING。
#### 5、 TERMINATED
> (1) 状态说明：线程池彻底终止，就变成TERMINATED状态。 </p>
> (2) 状态切换：线程池处在TIDYING状态时，执行完terminated()之后，就会由 TIDYING -> TERMINATED。

### Thread类的几种方法
##### 1) start方法
> start()用来启动一个线程，当调用start方法后，系统才会开启一个新的线程来执行用户定义的子任务，在这个过程中，会为相应的线程分配需要的资源。

##### 2）run方法

>　run()方法是不需要用户来调用的，当通过start方法启动一个线程之后，当线程获得了CPU执行时间，便进入run方法体去执行具体的任务。注意，继承Thread类必须重写run方法，在run方法中定义具体要执行的任务。

##### 　　3）sleep方法

>　sleep方法有两个重载版本：


```
sleep(long millis)     //参数为毫秒
 
sleep(long millis,int nanoseconds)    //第一参数为毫秒，第二个参数为纳秒
```

 
>　sleep相当于让线程睡眠，交出CPU，让CPU去执行其他的任务。
　　但是有一点要非常注意，sleep方法不会释放锁，也就是说如果当前线程持有对某个对象的锁，则即使调用sleep方法，其他线程也无法访问这个对象。看下面这个例子就清楚了：

>　注意，如果调用了sleep方法，必须捕获InterruptedException异常或者将该异常向上层抛出。当线程睡眠时间满后，不一定会立即得到执行，因为此时可能CPU正在执行其他的任务。所以说调用sleep方法相当于让线程进入阻塞状态。
wait方法会让线程进入阻塞状态，并且会释放线程占有的锁，并交出CPU执行权限。
　　由于wait方法会让线程释放对象锁，所以join方法同样会让线程释放对一个对象持有的锁。
##### 4）yield方法

> 调用yield方法会让当前线程交出CPU权限，让CPU去执行其他的线程。它跟sleep方法类似，同样不会释放锁。但是yield不能控制具体的交出CPU的时间，另外，yield方法只能让拥有相同优先级的线程有获取CPU执行时间的机会。

> 注意，调用yield方法并不会让线程进入阻塞状态，而是让线程重回就绪状态，它只需要等待重新获取CPU执行时间，这一点是和sleep方法不一样的。

##### 　　5）join方法

> 　join方法有三个重载版本：


```
join()
join(long millis)     //参数为毫秒
join(long millis,int nanoseconds)    //第一参数为毫秒，第二个参数为纳秒
```

 
>　　假如在main线程中，调用thread.join方法，则main方法会等待thread线程执行完毕或者等待一定的时间。如果调用的是无参join方法，则等待thread执行完毕，如果调用的是指定了时间参数的join方法，则等待一定的事件。

>　wait方法会让线程进入阻塞状态，并且会释放线程占有的锁，并交出CPU执行权限。由于wait方法会让线程释放对象锁，所以join方法同样会让线程释放对一个对象持有的锁。具体的wait方法使用在后面文章中给出。

##### 　　6）interrupt方法

>　interrupt，顾名思义，即中断的意思。单独调用interrupt方法可以使得处于阻塞状态的线程抛出一个异常，也就说，它可以用来中断一个正处于阻塞状态的线程；另外，通过interrupt方法和isInterrupted()方法来停止正在运行的线程。

##### 　　7）stop方法

>　　stop方法已经是一个废弃的方法，它是一个不安全的方法。因为调用stop方法会直接终止run方法的调用，并且会抛出一个ThreadDeath错误，如果线程持有某个对象锁的话，会完全释放锁，导致对象状态不一致。所以stop方法基本是不会被用到的。

##### 　8）destroy方法

>　　destroy方法也是废弃的方法。基本不会被使用到。

###### 　以下是关系到线程属性的几个方法：

> 1）getId
　　用来得到线程ID

>　　2）getName和setName
　　用来得到或者设置线程名称。

>　　3）getPriority和setPriority
　　用来获取和设置线程优先级。

>　　4）setDaemon和isDaemon
　　用来设置线程是否成为守护线程和判断线程是否是守护线程。

>　　守护线程和用户线程的区别在于：</p>守护线程依赖于创建它的线程，而用户线程则不依赖。举个简单的例子：如果在main线程中创建了一个守护线程，当main方法运行完毕之后，守护线程也会随着消亡。而用户线程则不会，用户线程会一直运行直到其运行完毕。在JVM中，像垃圾收集器线程就是守护线程。


