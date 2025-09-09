package com.gagechaeum.backend.policy.service;

import org.springframework.scheduling.annotation.Async;

public interface PolicySyncService {

    @Async("taskExecutor")
    void syncPolicies();
}