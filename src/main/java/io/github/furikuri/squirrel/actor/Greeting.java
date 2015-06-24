package io.github.furikuri.squirrel.actor;

import java.io.Serializable;

public class Greeting implements Serializable {
    public final String who;

    public Greeting(String who) {
        this.who = who;
    }
}
