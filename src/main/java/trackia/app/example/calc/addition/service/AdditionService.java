package trackia.app.example.calc.addition.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import trackia.app.Trackia;
import trackia.app.example.calc.addition.dao.AdditionDao;
import trackia.app.example.calc.addition.to.CalcRequest;
import trackia.app.example.calc.addition.to.CalcResponse;


@Service
@AllArgsConstructor
@Log4j2
public class AdditionService {
	private final AdditionDao dao;
	
	@Trackia
	public CalcResponse calc(CalcRequest request){
		log.info("calc start");
		return dao.calc(request.getLeft(), request.getRight());
	}
}
