package trackia.app.example.calc.addition.dao;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import trackia.app.Trackia;
import trackia.app.annotations.R;
import trackia.app.example.calc.addition.to.CalcResponse;
import trackia.app.to.Journal;

@Repository
@AllArgsConstructor
@Log4j2
public class AdditionDao {
	private final CalcDao calcDao;
	@Trackia(value = "DAO_CALC", description = "Addition calc")
	public CalcResponse calc(@R Object left, @R Object right, Journal journal) {
		log.info("calc start");
		return new CalcResponse(calcDao.value(left, "left", journal) + 
				                calcDao.value(right, "right", journal), 
				                journal.getTransactionId());
	}
	

}
