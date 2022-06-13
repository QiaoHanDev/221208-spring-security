package io.crowdcode.cloudbay.catalog;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
@SpringBootTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CatalogServiceApplicationTest {

    @Test
    void check_if_application_context_starts_with_default_profiles() {
        // nothing to do here
    }
}
