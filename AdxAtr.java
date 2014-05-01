import java.math.BigDecimal;
import com.breezetrader.Context;
import com.breezetrader.Event;
import com.breezetrader.OrderType;
import com.breezetrader.Strategy;
import com.breezetrader.Tick;

public class AdxAtr extends Strategy {
	
	boolean flag = false;

	/*
	*  initialize your context, 
	*  technical indicators other variables
	*/
	public void initialize(Context context)	{	

	String symbol = "HINDUNILVR";
	
			initTALib("adx","adx", "14", "9", symbol, "close" );
			context.setDataFrequency(2, Context.Frequency.DAY);
			context.setSymbols(symbol);
			context.setPortfolioValue(BigDecimal.valueOf(100000));
			context.setDataType(Event.Type.BAR);
			context.setStartDate("03-9-2012");
			context.setEndDate("31-10-2012");
			log("Initialized");
	}
	
	/*
	*  onEvent is the callback when a market event happens. 
	*  The behaviour of how this is called depends on the context 
	*  object you intialized in intialize(Context context) 
	*/
	
	public void onEvent(Object object) {
		double adx = getData("adx");
		double rsi1 = getData("rsi1");
		log("ADX: "+adx + "\n");
//		log("macd1hist: "+macd1Hist);
//		log("macd1sig: "+macd1Sig);
		log("current Time: "+getTimeStamp());
    }
	
}