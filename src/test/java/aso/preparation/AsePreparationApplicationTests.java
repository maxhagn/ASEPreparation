package aso.preparation;

import aso.preparation.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AsePreparationApplicationTests {

    @Autowired
    TodoService todoService;

    @Test
    void contextLoads() {
    }

}
