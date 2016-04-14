package com.feel.backend;

/**
 * Created by Sass on 14.04.2016.
 */

import com.feel.backend.configuration.Server;
import org.glassfish.grizzly.http.server.CLStaticHttpHandler;
import org.glassfish.grizzly.http.server.HttpHandler;

public class ServerRunner extends Server {
    @Override
    public boolean getFileCacheEnabled() {
        return true;
    }

    @Override
    public HttpHandler getHttpHandler() {
        return new CLStaticHttpHandler(ServerRunner.class.getClassLoader(), "webapp/");
    }
}
