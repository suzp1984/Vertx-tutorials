package com.github.suzp1984.vertx.testcore;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;


/**
 * Created by moses on 12/24/15.
 */
public class MyVerticle extends AbstractVerticle {

    @Override
    public void start() {
        System.out.println("My Verticle start");

        getVertx().setTimer(1000, id -> {
            System.out.println("And one second later this is printed");
        });

        System.out.println("First this is printed");

        EventBus eb = vertx.eventBus();
        eb.consumer("news.uk.sport", message -> {
            System.out.println("I have received a message: " + message.body());
        });

        //vertx.deployVerticle("com.github.suzp1984.vertx.testcore.SecondVerticle");
    }

    @Override
    public void stop() {
        System.out.println( "My Verticle stop" );
    }

}
