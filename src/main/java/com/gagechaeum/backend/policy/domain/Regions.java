package com.gagechaeum.backend.policy.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Regions {
    private Long regionId;
    private Long superId;
    private int depth;
    private String name;
    private String fullName;
}