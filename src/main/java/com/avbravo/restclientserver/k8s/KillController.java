package com.avbravo.restclientserver.k8s;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/kill")
public class KillController {

    @GET
    public void doKill() {
        System.exit(-1);
    }
}
