package com.github.invictum;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Settings {

    final URL hub;
    final URI socket;
    int heartBeatInterval = 60000;

    public Settings(String host) {
        try {
            hub = new URL("http://" + host + "/wd/hub");
            socket = URI.create("ws://" + host);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Unable to build url from " + host);
        }
    }

    public Settings withHeatBeatInterval(int heartBeatInterval) {
        this.heartBeatInterval = heartBeatInterval;
        return this;
    }
}
