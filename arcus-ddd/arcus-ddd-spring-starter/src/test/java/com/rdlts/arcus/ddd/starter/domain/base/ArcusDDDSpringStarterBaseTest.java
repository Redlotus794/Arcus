package com.rdlts.arcus.ddd.starter.domain.base;

import com.rdlts.arcus.ddd.starter.ArcusDDDSpringStarterApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = ArcusDDDSpringStarterApplication.class)
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class ArcusDDDSpringStarterBaseTest {


}
