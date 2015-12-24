package com.github.suzp1984.vertx.testcore;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.EventBus;

/**
 * Created by jacobsu on 12/24/15.
 */
public class SecondVerticle extends AbstractVerticle {

    @Override
    public void start() {
        System.out.println("Second Verticle start");

        EventBus eb = vertx.eventBus();

        eb.publish("news.uk.sport", "Yay! Someone kicked a ball");

        vertx.setTimer(1000, id -> {
            eb.publish("news.uk.sport", "Send in Timer");
        });

        eb.send("news.uk.sport", "Yay! Someone kicked a ball across a patch of grass", ar -> {
            if (ar.succeeded()) {
                System.out.println("Received reply: " + ar.result().body());
            }
        });
    }

    public void stop() {

    }
}
