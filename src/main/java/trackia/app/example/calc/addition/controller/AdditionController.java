package trackia.app.example.calc.addition.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import trackia.app.Trackia;
import trackia.app.example.calc.addition.service.AdditionService;
import trackia.app.example.calc.addition.to.CalcRequest;
import trackia.app.example.calc.addition.to.CalcResponse;
import trackia.app.module.sla.Slable;
import trackia.app.module.sysinfo.Infoable;

@RestController
@AllArgsConstructor
@Log4j2
public class AdditionController {
	
	private final AdditionService service;
	
	@Trackia(description = "Calc Addition TrackIA example", write = true)
	@Slable(3000)
	@Infoable
	
	@PostMapping("addition")
	public ResponseEntity<CalcResponse> addition(@Validated @RequestBody CalcRequest request) {
		log.info("addition start");
		
		return new ResponseEntity<>(service.calc(request), HttpStatus.OK); 
	}
}
