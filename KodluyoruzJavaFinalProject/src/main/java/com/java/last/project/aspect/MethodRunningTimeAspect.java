package com.java.last.project.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import com.java.last.project.annotion.MethodRunningTime;

@Aspect
@Component
public class MethodRunningTimeAspect {

	@Around("@annotation(methodRunningTime1)")
	public Object execute(ProceedingJoinPoint point, MethodRunningTime methodRunningTime1) throws Throwable {
		// execute MethodRunningTime ile kestiğimiz fonksiyonlar üzerinden yapılacak
		// işlemler

		if (!methodRunningTime1.active()) {
			return point.proceed();
		}

		String className = point.getSignature().getDeclaringType().getSimpleName();
		String methodName = point.getSignature().getName();

		StopWatch stopWatch = new StopWatch();

		stopWatch.start();

		Object result = point.proceed();

		System.out.println(className + "#" + methodName + " runned in " + stopWatch.getTotalTimeMillis() + " ms");

		return result;
	}

}
