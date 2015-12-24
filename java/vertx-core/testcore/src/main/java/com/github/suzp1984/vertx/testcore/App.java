package com.github.suzp1984.vertx.testcore;

import io.vertx.core.Vertx;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        MyVerticle myVerticle = new MyVerticle();

        Vertx vertx = Vertx.vertx();
        vertx.deployVerticle(myVerticle);

        vertx.deployVerticle("com.github.suzp1984.vertx.testcore.SecondVerticle");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // vertx.close();
        myVerticle.deploymentID();

        // vertx.undeploy("com.github.suzp1984.vertx.testcore.MyVerticle");
    }
}
