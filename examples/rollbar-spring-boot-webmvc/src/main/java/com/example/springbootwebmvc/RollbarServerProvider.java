package com.example.springbootwebmvc;

import com.rollbar.api.payload.data.Server;
import com.rollbar.notifier.provider.Provider;

public class RollbarServerProvider implements Provider<Server> {

    @Override
    public Server provide() {
        return new Server.Builder()
                .codeVersion("java-spring-webinar")
                .branch("java-spring-webinar")
                .host("localhost")
                .root("com.example.springbootwebmvc")
                .build();
    }
}