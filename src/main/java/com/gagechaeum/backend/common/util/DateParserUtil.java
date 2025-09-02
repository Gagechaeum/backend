package com.gagechaeum.backend.common.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateParserUtil {

    // 하이픈(-)과 점(.)을 모두 인식하는 정규식
    private static final Pattern DATE_PATTERN = Pattern.compile("(\\d{4}[-.]\\d{2}[-.]\\d{2})");
    // 표준 날짜 형식
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDate[] parseDateRange(String periodString) {
        if (periodString == null || periodString.isBlank() || periodString.contains("상시") || periodString.contains("수시") || periodString.contains("없음") || periodString.contains("따름")) {
            return new LocalDate[]{null, null};
        }

        Matcher matcher = DATE_PATTERN.matcher(periodString);
        List<LocalDate> foundDates = new ArrayList<>();

        // 문자열에서 날짜 패턴을 모두 찾는다.
        while (matcher.find()) {
            try {
                // 찾은 날짜 문자열을 표준 형식(YYYY-MM-DD)으로 변환
                String standardizedDateString = matcher.group(1).replace('.', '-');
                foundDates.add(LocalDate.parse(standardizedDateString, FORMATTER));
            } catch (DateTimeParseException e) {
                // 파싱 중 오류가 발생하면 무시하고 다음 검색 계속
            }
        }

        // 찾은 날짜의 개수에 따라 시작일과 종료일을 결정
        if (foundDates.isEmpty()) {
            return new LocalDate[]{null, null};
        } else if (foundDates.size() == 1) {
            return new LocalDate[]{foundDates.get(0), null}; // 날짜가 하나면 시작일로 간주
        } else {
            // 날짜가 두 개 이상이면 첫 번째를 시작일, 두 번째를 종료일로 간주
            return new LocalDate[]{foundDates.get(0), foundDates.get(1)};
        }
    }
}