package com.rdlts.arcus.identity.base;

import com.rdlts.arcus.identity.ArcusIdentityTestApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = ArcusIdentityTestApplication.class)
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class ArcusIdentityBaseTest {
}
