package com.gagechaeum.backend.policy.service;

public interface PolicySyncService {
    void syncPolicies();
    void syncPolicyDetails();
    void applyPolicyDetailsAsync();
}