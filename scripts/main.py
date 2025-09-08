import sys
import json
import pandas as pd
from matching_logic.region_matcher import find_region_id
from matching_logic.industry_matcher import find_industry_id

def run_matching_process():
    # 1. Java로부터 표준 입력(stdin)으로 JSON 데이터를 받음
    input_data = json.load(sys.stdin)

    # 2. 받은 데이터로 Pandas DataFrame 생성
    policies_data = input_data['policies']
    regions_df = pd.DataFrame(input_data['regions'])
    industry_df = pd.DataFrame(input_data['industries'])

    results = []
    # 3. 각 정책에 대해 분리된 모듈의 함수를 호출하여 매칭 수행
    for policy in policies_data:
        policy_text = " ".join(filter(None, [
            policy.get('serviceName'),
            policy.get('organizationName'),
            policy.get('supportTarget')
        ]))

        region_id = find_region_id(policy_text, regions_df)
        industry_id = find_industry_id(policy_text, industry_df)

        results.append({
            'policyId': policy.get('serviceId'),
            'regionId': region_id,
            'industryId': industry_id
        })

    # 4. 최종 결과를 JSON으로 표준 출력(stdout)하여 Java에 전달
    print(json.dumps(results, ensure_ascii=False))

if __name__ == "__main__":
    run_matching_process()