# Git Commit Hook 안내

이 프로젝트는 커밋 메시지 컨벤션을 자동으로 검사합니다.  
형식에 맞지 않으면 커밋이 거부됩니다.

## 커밋 메시지 형식

> <프리픽스>: <내용>
> <br><br> 예시) feat: 로그인 기능 추가
><br>ex) git commit -m 'Feat : 타임테이블 기능 추가`
## **Prefix**

- **Feat**: 새로운 기능 추가 (feature)
- **Fix**: 버그 수정 (bug fix)
- **Docs**: 문서 변경 (documentation)
- **Style**: 코드 포맷팅, 세미콜론 누락 등 코드 변경이 없는 경우
- **Refactor**: 코드 리팩토링
- **Test**: 테스트 코드 추가, 수정
- **Chore**: 빌드 프로세스나 도구 설정 변경
- **CI**: CI 관련 설정 변경
- **CD**: CD 관련 설정 변경
- **Perf**: 성능 개선 관련 변경
---

## 설정 방법 (최초 1회)

setup.sh 파일로 만들어둠, 아래의 코드를 터미널에서 실행

```터미널에서 실행
bash .github/hooks/setup.sh
```

---
## commit 메시지 작성시 참고
### 1. 에디터 설정
```터미널에서 실행
#  에디터를 nano로 변경

git config --global core.editor "nano"
```

### 2. 내용 작성
```터미널에서 실행
#  예시

feat: 회원가입 API 추가
```

### 3. 저장하고 종료
```
- 저장 : Ctrl + O
- 종료 : Ctrl + X
```