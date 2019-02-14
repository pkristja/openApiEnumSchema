package com.example.openapiexample.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(description = "<div class=\\\"renderedMarkdown\\\"><p>Rank of developer.</p>\\n\" +\n" +
        "        \"<p>Valid values are:</p>\\n\" +\n" +
        "        \"<ul>\\n\" +\n" +
        "        \"<li>'JUNIOR_DEVELOPER_1': Text for junior 1.\\n\" +\n" +
        "        \"<li>'JUNIOR_DEVELOPER_2': Text for junior 1.\\n\" +\n" +
        "        \"<li>'JUNIOR_DEVELOPER_3': Text for junior 1.\\n\" +\n" +
        "        \"<li>'SENIOR_DEVELOPER_1': Text for junior 1.\\n\" +\n" +
        "        \"<li>'SENIOR_DEVELOPER_2': Text for junior 1.\\n\" +\n" +
        "        \"<li>'SENIOR_DEVELOPER_3': Text for junior 1.\\n\" +\n" +
        "        \"</ul>\\n\" +\n" +
        "        \"<p>Random text...\\n\" +\n" +
        "        \"and has to be added to this API definition as well.</p></div>",
        enumeration = {"junior_developer_1", "junior_developer_2", "junior_developer_3",
                "senior_developer_1", "senior_developer_2", "senior_developer_3"})
public enum Rank {
    JUNIOR_DEVELOPER_1("junior_developer_1"),
    JUNIOR_DEVELOPER_2("junior_developer_2"),
    JUNIOR_DEVELOPER_3("junior_developer_3"),
    SENIOR_DEVELOPER_1("senior_developer_1"),
    SENIOR_DEVELOPER_2("senior_developer_2"),
    SENIOR_DEVELOPER_3("senior_developer_3");

    private String value;

    Rank(String value) {
        this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static Rank fromValue(String text) {
        for (Rank b : Rank.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }
}
