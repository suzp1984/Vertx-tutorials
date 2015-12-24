package com.github.suzp1984.vertx.testcore;

import io.vertx.core.AbstractVerticle;

/**
 * Created by moses on 12/24/15.
 */
public class MyVerticle extends AbstractVerticle {

    @Override
    public void start() {
        System.out.println( "My Verticle start" );
    }

    @Override
    public void stop() {
        System.out.println( "My Verticle stop" );
    }

}
