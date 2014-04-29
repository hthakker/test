import java.math.BigDecimal;
import com.breezetrader.Context;
import com.breezetrader.Event;
import com.breezetrader.OrderType;
import com.breezetrader.Strategy;
import com.breezetrader.Tick;
/*
*  This is a sample strategy intended to get you started.
*  For more details on the APIs and usage please visit 
*  http://docs.breezetrader.com
*
*/
public class HelloWorld extends Strategy {

        // This is for trending market
        boolean flag = false;

        String symbol = "ITC";
        double ma3, ma5, lma5, lma3;
        /*

        *  initialize your context,
        *  technical indicators other variables

        */
        public void initialize(Context context)
        {

                        initTALib("ma", "ma10", "10","Ema", symbol, "close" );
                        initTALib("ma", "ma50", "50","Ema", symbol, "close" );

                      //  talib_init("lookback", "lma5",  "5", "ma5");
                       // talib_init("lookback", "lma3",  "5", "ma3");
                        context.setDataFrequency(1, Context.Frequency.DAY);
                        context.setSymbols(symbol);
                        //context.setDataURL("https://s3-ap-southeast-1.amazonaws.com/breezetrader-test/EU0009652759.csv");

                        context.setPortfolioValue(BigDecimal.valueOf(150000));
                        context.setDataType(Event.Type.BAR);

                        context.setStartDate("01-01-2011");
                        context.setEndDate("31-12-2013");

                        log("Initialized");
                        lma3 =0;

                        lma5 =0;
                        ma3 = 0;

                        ma5 = 0;

        }


        /*
        *  onEvent is the callback when a market event happens.

        *  The behaviour of how this is called depends on the context
        *  object you intialized in intialize(Context context)

        */

        public void onEvent(Object object)

        {
                lma5= ma5;// talib_data("lma5");
                lma3= ma3;//talib_data("lma3");

                ma3 = getData("ma10");
                ma5 = getData("ma50");

                if(ma3>ma5 && lma3<= lma5)
                {
                    log("openpositions: "+getPosition(symbol));

                    if(getPosition(symbol) < 0){
                        closeAllPositions(symbol);

                    }
                    log("ID: "+order(OrderType.Market,symbol, 2000));


                        

                }
                if(ma3<ma5 && lma3>= lma5)
                {

                    log("openpositions: "+getPosition(symbol));
                    if(getPosition(symbol) > 0){

                        closeAllPositions(symbol);
                    }

                    //log("ID: "+order(OrderType.Market,symbol, -75));

                }


        }


}