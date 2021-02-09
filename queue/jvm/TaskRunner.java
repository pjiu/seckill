package com.seckill.queue.jvm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.itstyle.seckill.common.entity.SuccessKilled;
import com.itstyle.seckill.service.ISeckillService;

@Component
public class TaskRunner implements ApplicationRunner{
	
	@Autowired
	private ISeckillService seckillService;
	
	@Override
    public void run(ApplicationArguments var) throws Exception{
		while(true){
			//进程内队列
			SuccessKilled kill = SeckillQueue.getMailQueue().consume();
			if(kill!=null){
				seckillService.startSeckil(kill.getSeckillId(), kill.getUserId());
			}
		}
    }
}