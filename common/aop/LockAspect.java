package com.seckill.common.aop;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope
@Aspect
public class LockAspect {

	private static  Lock lock = new ReentrantLock(true);//互斥锁 参数默认false，不公平锁  
	
	//Service层切点     用于记录错误日志
	@Pointcut("@annotation(com.itstyle.seckill.common.aop.Servicelock)")  
	public void lockAspect() {
		
	}
	
    @Around("lockAspect()")
    public  Object around(ProceedingJoinPoint joinPoint) { 
    	lock.lock();
    	Object obj = null;
		try {
			obj = joinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		} finally{
			lock.unlock();
		}
    	return obj;
    } 
}
