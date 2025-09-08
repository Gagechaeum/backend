package com.gagechaeum.backend.policy.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gagechaeum.backend.policy.domain.Industry;
import com.gagechaeum.backend.policy.domain.Region;
import com.gagechaeum.backend.policy.dto.external.Gov24ApiServiceDto;
import com.gagechaeum.backend.policy.dto.python.MatchingResultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class PythonMatcherService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${python.matcher.script.path}")
    private String scriptPath;

    public List<MatchingResultDto> match(List<Gov24ApiServiceDto> policies, List<Region> regions, List<Industry> industries) throws IOException, InterruptedException {
        Map<String, Object> inputData = new HashMap<>();
        inputData.put("policies", policies);
        inputData.put("regions", regions);
        inputData.put("industries", industries);

        String jsonInput = objectMapper.writeValueAsString(inputData);

        ProcessBuilder pb = new ProcessBuilder("python", scriptPath);
        Process process = pb.start();

        try (OutputStream os = process.getOutputStream()) {
            os.write(jsonInput.getBytes(StandardCharsets.UTF_8));
        }

        String jsonOutput = new String(process.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        String errorOutput = new String(process.getErrorStream().readAllBytes(), StandardCharsets.UTF_8);
        if (!errorOutput.isEmpty()) {
            log.error("Python script error: {}", errorOutput);
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException("Python script failed with exit code: " + exitCode);
        }

        return objectMapper.readValue(jsonOutput, new TypeReference<>() {});
    }
}