package com.seckill.queue.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.itstyle.seckill.service.ISeckillService;

@Component
public class KafkaConsumer {
	@Autowired
	private ISeckillService seckillService;
    /**
     * 监听seckill主题,有消息就读取
     * @param message
     */
    @KafkaListener(topics = {"seckill"})
    public void receiveMessage(String message){
    	//收到通道的消息之后执行秒杀操作
    	String[] array = message.split(";"); 
    	seckillService.startSeckil(Long.parseLong(array[0]), Long.parseLong(array[1]));
    }
}