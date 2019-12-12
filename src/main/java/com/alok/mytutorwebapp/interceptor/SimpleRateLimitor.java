package com.alok.mytutorwebapp.interceptor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SimpleRateLimitor {

    private Semaphore semaphore;
    private TimeUnit timeUnit;
    private int maxPermit;
    private ScheduledExecutorService scheduledExecutorService;

    public SimpleRateLimitor(TimeUnit timeUnit, int maxPermit){
        this.maxPermit = maxPermit;
        this.timeUnit = timeUnit;
        this.semaphore = new Semaphore(maxPermit);

    }

    public static SimpleRateLimitor create(TimeUnit timeUnit, int maxPermit){
        SimpleRateLimitor rateLimitor   =   new SimpleRateLimitor(timeUnit, maxPermit);
        rateLimitor.scheduleRateLimitor();
        return rateLimitor;
    }

    private void scheduleRateLimitor() {
        scheduledExecutorService    =   Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
                    semaphore.release(maxPermit-semaphore.availablePermits());
                }
                ,1,1,timeUnit);
    }

    public void destroy(){
        scheduledExecutorService.shutdown();
    }

    public boolean tryAcquire(){
        return semaphore.tryAcquire();
    }

}