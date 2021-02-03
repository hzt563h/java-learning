package thread;

import com.hzt.demo.thread.MyRunnable;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author huangzetao
 * @version 1.0.0
 * @ClassName ThreadTest.java
 * @Description TODO
 * @createTime 2021年02月03日 09:26:00
 */
public class ThreadTest {
    /**
     * Executor 管理多个异步任务的执行，而无需程序员显式地管理线程的生命周期。这里的异步是指多个任务的执行互不干扰，不需要进行同步操作。
     *
     * 主要有三种 Executor：
     *
     * CachedThreadPool：一个任务创建一个线程；
     * FixedThreadPool：所有任务只能使用固定大小的线程；
     * SingleThreadExecutor：相当于大小为 1 的 FixedThreadPool。
     */
    @Test
    public void executorTest(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new MyRunnable());
        }
        executorService.shutdown();
    }

    /**
     * 守护线程是程序运行时在后台提供服务的线程，不属于程序中不可或缺的部分。
     *
     * 当所有非守护线程结束时，程序也就终止，同时会杀死所有守护线程。
     *
     * main() 属于非守护线程。
     *
     * 在线程启动之前使用 setDaemon() 方法可以将一个线程设置为守护线程。
     */
    @Test
    public void daemonTest(){
        Thread thread = new Thread(new MyRunnable());
        thread.setDaemon(true);
        thread.start();
    }
}
