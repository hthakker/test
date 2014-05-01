import java.math.BigDecimal;
import com.breezetrader.Context;
import com.breezetrader.Event;
import com.breezetrader.OrderType;
import com.breezetrader.Strategy;
import com.breezetrader.Tick;

public class EMA1020 extends Strategy {
	
	boolean flag = false;
	String symbol = "HINDUNILVR";
	double qty = 100;
	double ema10 = 0;
	/*
	*  initialize your context, 
	*  technical indicators other variables
	*/
	public void initialize(Context context)	{	

			initTALib("ma","ema10", "10", "ema", symbol, "close" );

			context.setDataFrequency(1, Context.Frequency.DAY);
			context.setSymbols(symbol);
			context.setPortfolioValue(BigDecimal.valueOf(100000));
			context.setDataType(Event.Type.BAR);
            context.setStartDate("01-02-2012");
            context.setEndDate("31-12-2013");
			log("Initialized");
	}
	
	 public void onEvent(Object object) {
    	prev_ema10 = ema10;

    	ema10 = getData("ema10");

        if(ema10 > prev_ema10) {
                    
            log("openpositions: "+getPosition(symbol));
            if(getPosition(symbol) < 0){
                closeAllPositions(symbol);
            }

        log("ID: "+order(OrderType.Market,symbol, 100));

        }
    
        if(ema10 < prev_ema10) {
            log("openpositions: "+getPosition(symbol));
            if(getPosition(symbol) > 0){
                closeAllPositions(symbol);
            }
        }
	 }
}