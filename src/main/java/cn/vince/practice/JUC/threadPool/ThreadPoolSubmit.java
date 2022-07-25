package cn.vince.practice.JUC.threadPool;

import java.util.concurrent.*;

public class ThreadPoolSubmit {


    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 10, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(50));
        Future<String> submit = poolExecutor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {

                return "ok~~~";
            }
        });
        String s1 = submit.get();
        System.out.println(s1);



        CompletableFuture.runAsync(() -> {

        }, poolExecutor);
    }



}
