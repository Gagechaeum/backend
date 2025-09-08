import pandas as pd

def find_region_id(policy_text: str, regions_df: pd.DataFrame) -> int:
    """정책 텍스트에서 지역명을 찾아 ID를 반환 (정확도를 위해 긴 이름부터 검색)"""
    # 'full_name' 길이를 기준으로 내림차순 정렬
    sorted_regions = regions_df.sort_values(
        by='full_name',
        key=lambda col: col.str.len(),
        ascending=False
    )
    for _, row in sorted_regions.iterrows():
        if isinstance(row['full_name'], str) and row['full_name'] in policy_text:
            return row['region_id']
    return None