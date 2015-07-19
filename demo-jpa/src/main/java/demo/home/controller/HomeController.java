package demo.home.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.qos.logback.classic.Logger;

@Controller
class HomeController {
	
	Logger logger = (Logger)LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("/")
	String index() {
		logger.info("Hello World!");
		return "index";
	}
}