package com.bossien.sampleweb;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
public class TestController {
	@GetMapping("")
	public String get() {
		return "test";
	}

	@PostMapping("create")
	public String create(
			@Validated @RequestBody TestDto dto
	) {
		return "ok";
	}
}
