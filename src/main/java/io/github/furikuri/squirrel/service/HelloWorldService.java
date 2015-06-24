package io.github.furikuri.squirrel.service;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import io.github.furikuri.squirrel.actor.Greeting;
import io.github.furikuri.squirrel.actor.GreetingActor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldService {

    @Value("${name:World}")
    private String name;

    private ActorSystem system = ActorSystem.create("MySystem");

    public String getHelloMessage() {
        ActorRef greeter = system.actorOf(Props.create(GreetingActor.class), "greeter");
        greeter.tell(new Greeting("Charlie Parker"), ActorRef.noSender());
        return "Hello " + this.name;
    }

}