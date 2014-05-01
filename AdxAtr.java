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
	public void initialize(Context context)
	{	
			initTALib("macd","macd1", "12", "26","9", "EU0009652759", "currentValueDouble" );
			initTALib("rsi","rsi1", "12", "EU0009652759", "currentValueDouble" );
	
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
		double macd1 = getData("macd1" , "macd");
		double macd1Hist = getData("macd1" , "macdhist");
		double rsi1 = getData("rsi1");
//		log("macd1: "+macd1);
//		log("macd1hist: "+macd1Hist);
//		log("macd1sig: "+macd1Sig);
		log("current Time: "+getTimeStamp());
    }
	