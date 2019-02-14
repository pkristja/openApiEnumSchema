package com.example.openapiexample.rest;

import com.example.openapiexample.model.Developer;
import com.example.openapiexample.model.Rank;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/hello")
@Tag(name = "Consent Service", description = "<div class=\"renderedMarkdown\">The Consent Service API offers all the needed services for consent management by TPP.</div>")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloWorldEndpoint {

    @GET
    @Operation(summary = "Get developer",
            description = "<div class=\"renderedMarkdown\"><p>This method returns developer</p></div>")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Developer.class))),
    })
    public Response getDeveloper() {

        Developer developer = new Developer();
        developer.setFirstName("John");
        developer.setLastName("Smith");
        developer.setDeveloperRank(Rank.SENIOR_DEVELOPER_3);

        return Response.ok(developer).build();
    }

}
