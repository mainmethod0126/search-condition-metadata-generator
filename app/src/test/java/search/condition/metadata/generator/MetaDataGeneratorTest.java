package search.condition.metadata.generator;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.github.mainmethod0126.search.condition.metadata.generator.MetaDataGenerator;

public class MetaDataGeneratorTest {

    @Test
    @DisplayName("Generates metadata from a valid domain class")
    public void testGenerator_whenNormalParam_thenSuccess() {

        String result = MetaDataGenerator.generate(TestOrder.class);

        System.out.println("metadata : " + result);

        assertThat(result).isNotNull().isNotEmpty();

    }

}
