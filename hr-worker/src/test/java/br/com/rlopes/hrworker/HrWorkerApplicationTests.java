package br.com.rlopes.hrworker;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HrWorkerApplicationTests {

	@Test
    void shouldInitializeApplication() {
        HrWorkerApplication.main(new String[] {});
        Assertions.assertTrue(true);
    }

}
