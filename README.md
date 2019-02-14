# @Schema annotation on Java Enum

## Building and running
Project is generated from https://thorntail.io/generator/ 

Build:
```
mvn clean install
```

To run the project just got to target foler after project is build and execute:
```
java -jar demo-thorntail.jar
```

After application is running go to ```localhost:8080/openapi``` to download OpenApi generated documentation.


## Issue with @Schema annotation

In this example I’m generating OpenAPI 3.0 documentation from annotated java code. But the issue is that when I add @Schema  annotation to enum all the values disappear. 

Snipped of generated OpenAPI 3.0 documentation:
```
  schemas:
    Developer:
      description: Schema for Developer object...
      required:
      - developerRank
      - firstName
      - lastName
      properties:
        developerRank:
          description: |-
            <div class=\"renderedMarkdown\"><p>Rank of developer.</p>\n" +
                    "<p>Valid values are:</p>\n" +
                    "<ul>\n" +
                    "<li>'JUNIOR_DEVELOPER_1': Text for junior 1.\n" +
                    "<li>'JUNIOR_DEVELOPER_2': Text for junior 2.\n" +
                    "<li>'JUNIOR_DEVELOPER_3': Text for junior 3.\n" +
                    "<li>'SENIOR_DEVELOPER_1': Text for senior 1.\n" +
                    "<li>'SENIOR_DEVELOPER_2': Text for senior 2.\n" +
                    "<li>'SENIOR_DEVELOPER_3': Text for senior 3.\n" +
                    "</ul>\n" +
                    "<p>Random text...\n" +
                    "and has to be added to this API definition as well.</p></div>
          type: string
          properties:
            value:
              type: string
        firstName:
          description: First name of the developer
          type: string
        lastName:
          description: Last name of the developer
          type: string

```

But if I remove @Schema annotation I get generated enum values but without description and required value like this:
```
schemas:
    Developer:
      description: Schema for Developer object...
      required:
      - firstName
      - lastName
      properties:
        developerRank:
          enum:
          - JUNIOR_DEVELOPER_1
          - JUNIOR_DEVELOPER_2
          - JUNIOR_DEVELOPER_3
          - SENIOR_DEVELOPER_1
          - SENIOR_DEVELOPER_2
          - SENIOR_DEVELOPER_3
          type: string
        firstName:
          description: First name of the developer
          type: string
        lastName:
          description: Last name of the developer
          type: string
```
