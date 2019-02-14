package com.example.openapiexample.model;

import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Data
@Schema(description = "Schema for Developer object...")
public class Developer {

    @Schema(required = true, description = "First name of the developer")
    private String firstName;
    @Schema(required = true, description = "Last name of the developer")
    private String lastName;
    //@Schema(required = true, implementation = Rank.class)
    private Rank developerRank;
}
