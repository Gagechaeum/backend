package com.gagechaeum.backend.policy.mapper;

import com.gagechaeum.backend.policy.domain.NewPolicyDetail;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NewPolicyMapper {
    void savePolicyDetail(NewPolicyDetail policyDetail);
}
