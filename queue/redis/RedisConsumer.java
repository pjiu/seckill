package com.seckill.queue.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seckill.service.ISeckillService;

@Service
public class RedisConsumer {
	
	@Autowired
	private ISeckillService seckillService;
	
    public void receiveMessage(String message) {
        //收到通道的消息之后执行秒杀操作(超卖)
    	String[] array = message.split(";"); 
    	seckillService.startSeckil(Long.parseLong(array[0]), Long.parseLong(array[1]));
    }
}