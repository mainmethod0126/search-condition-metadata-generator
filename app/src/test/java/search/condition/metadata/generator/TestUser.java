package search.condition.metadata.generator;

import io.github.mainmethod0126.search.condition.metadata.generator.annotation.MetaDataField;

public class TestUser {

    @MetaDataField(name = "uuid", type = "number", operators = {"=", "!="})
    private Long id;

    private String name;

}
