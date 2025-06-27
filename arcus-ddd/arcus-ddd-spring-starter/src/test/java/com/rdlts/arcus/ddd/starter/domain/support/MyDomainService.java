package com.rdlts.arcus.ddd.starter.domain.support;

import com.rdlts.arcus.ddd.core.domain.DomainService;
import org.springframework.stereotype.Service;

@Service
public class MyDomainService implements DomainService {

    public String testMethod() {
        return "This is a test method in TestDomainService";
    }
}
