import java.math.BigDecimal;
import com.breezetrader.Context;
import com.breezetrader.Event;
import com.breezetrader.OrderType;
import com.breezetrader.Strategy;
import com.breezetrader.Tick;

public class AdxAtr extends Strategy {
	
	boolean flag = false;
	String symbol = "HINDUNILVR";
	/*
	*  initialize your context, 
	*  technical indicators other variables
	*/
	public void initialize(Context context)	{	

			initTALib("adx","adx", "14", "9", symbol, "close" );
			initTALib("rsi","rsi14", "14", symbol, "close" );
			context.setDataFrequency(1, Context.Frequency.DAY);
			context.setSymbols(symbol);
			context.setPortfolioValue(BigDecimal.valueOf(100000));
			context.setDataType(Event.Type.BAR);
			context.setStartDate("01-01-2013");
			context.setEndDate("31-12-2013");
			log("Initialized");
	}
	
	/*
	*  onEvent is the callback when a market event happens. 
	*  The behaviour of how this is called depends on the context 
	*  object you intialized in intialize(Context context) 
	*/
	
	public void onEvent(Object object) {
		double adx = getData("adx");
		double rsi14 = getData("rsi14");
		log("RSI14: "+rsi14 + "\n");
//		log("ADX: "+adx + "\n");
//		log("macd1hist: "+macd1Hist);
//		log("macd1sig: "+macd1Sig);
		log("current Time: "+getTimeStamp());
    }
	
}