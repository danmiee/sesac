package org.zerock.api01.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/sample")
public class SampleController {
//    summary와 description은 Swagger UI에서 API 문서를 확인할 때 사용되는 정보이다. 노출되는 위치가 다름.
    @Operation(summary = "doA method", description = "샘플 doA 가져오기")
    @GetMapping("/doA")
    public List<String> doA() {
        return Arrays.asList("AAA", "BBB", "CCC");
    }
}
