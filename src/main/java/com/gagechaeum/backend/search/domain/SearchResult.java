package com.gagechaeum.backend.search.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchResult {
    private String type; // "POLICY" 또는 "LOAN"
    private String id;   // policy_id 또는 loan_id를 문자열로 받음
    private String name;
    private String industryName;
}
