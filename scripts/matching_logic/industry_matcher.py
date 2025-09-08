import pandas as pd

def find_industry_id(policy_text: str, industry_df: pd.DataFrame) -> int:
    """정책 텍스트에서 업종명 또는 키워드를 찾아 ID를 반환"""
    for _, row in industry_df.iterrows():
        keywords_to_check = [row['name']]
        if pd.notna(row['keywords']):
            keywords_to_check.extend(row['keywords'].split(','))

        if any(keyword.strip() in policy_text for keyword in keywords_to_check if keyword):
            return row['industry_id']
    return None