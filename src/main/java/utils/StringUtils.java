package utils;

import lombok.extern.log4j.Log4j2;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

@Log4j2
public class StringUtils {

    /**
     *
     * @param number - any string number
     * @return - the same number formatted as a price. E.g. 523000 will be returned as $523,000.00
     */
    public static String getNumberAsCurrency(String number){
        NumberFormat usdPriceFormatter = NumberFormat.getCurrencyInstance(Locale.US);
        usdPriceFormatter.setCurrency(Currency.getInstance("USD"));
        return usdPriceFormatter.format(Double.valueOf(number));
    }

    /**
     *
     * @param number - any string number
     * @return - the same number formatted as a price. E.g. 523000 will be returned as 523,000
     */
    public static String getNumber(String number){
        NumberFormat numberFormatter = NumberFormat.getNumberInstance();
        return numberFormatter.format(Double.valueOf(number));
    }

    /**
     *
     * @param text test
     * @param keywords
     * @return
     */
    public static boolean containsAllWords(String text, String ...keywords) {
        log.debug(String.format("Validation that string '%s' contains the following keywords: %s", text, keywords));
        for (String k : keywords)
            if (!text.contains(k)) return false;
        return true;
    }
}
