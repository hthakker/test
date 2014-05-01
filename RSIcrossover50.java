import java.math.BigDecimal;
import com.breezetrader.Context;
import com.breezetrader.Event;
import com.breezetrader.OrderType;
import com.breezetrader.Strategy;
import com.breezetrader.Tick;

public class RSIcrossover50 extends Strategy {
	
	boolean flag = false;
	String symbol = "HINDUNILVR";
	double qty = 100;
	double prev_rsi9, rsi9,rsi14=0;
	/*
	*  initialize your context, 
	*  technical indicators other variables
	*/
	public void initialize(Context context)	{	

	//		initTALib("adx","adx", "14", "9", symbol, "close" );
			initTALib("rsi","rsi14", "14", symbol, "close" );
			initTALib("rsi","rsi9", "9", symbol, "close" );
			context.setDataFrequency(1, Context.Frequency.DAY);
			context.setSymbols(symbol);
			context.setPortfolioValue(BigDecimal.valueOf(100000));
			context.setDataType(Event.Type.BAR);
            context.setStartDate("01-02-2012");
            context.setEndDate("31-12-2013");
			log("Initialized");
	}
	
	 public void onEvent(Object object) {
    	prev_rsi9 = rsi9;
    	
    	rsi9 = getData("rsi9");
		rsi14 = getData("rsi14");
	    log("RSI9: "+rsi9);
	    log("RSI14: "+rsi14);
        
        if( rsi9 > 50 && prev_rsi9 <=50) {
                    
            log("openpositions: "+getPosition(symbol));
            if(getPosition(symbol) < 0){
                closeAllPositions(symbol);
            }

        log("ID: "+order(OrderType.Market, symbol, qty));

        }
    
        if(rsi9 < 50 && prev_rsi9 >=50) {
            log("openpositions: "+getPosition(symbol));
            if(getPosition(symbol) > 0){
                closeAllPositions(symbol);
            }

        //log("ID: "+order(OrderType.Market,symbol, -75));

        }


	 }
	 
	 
}