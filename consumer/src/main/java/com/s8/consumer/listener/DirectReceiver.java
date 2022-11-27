package com.s8.consumer.listener;

import com.sun.media.jfxmedia.logging.Logger;
import lombok.extern.log4j.Log4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: Brooke Li
 * @E-mail: Halloworld1992@outlook.com
 * @Date: Created in $[TIME] $[DATE]
 * @Description:
 * @Modified by:
 */
@Component
@RabbitListener(queues = "TestDirectQueue")

public class DirectReceiver {

    @RabbitHandler
    public void process(Map testMessage){
        System.out.println("received: "+testMessage.toString());
    }
}
