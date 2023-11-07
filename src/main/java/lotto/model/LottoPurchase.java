package lotto.model;

import static lotto.util.Constant.LOTTO_PER_PRICE;
import static lotto.util.ErrorMessage.ERROR_MINIMUM_PRICE;
import static lotto.util.ErrorMessage.ERROR_NOT_DIVIDE_LOTTO_PRICE;
import static lotto.util.ErrorMessage.ERROR_NUMERIC_TYPE;

import java.util.regex.Pattern;

public class LottoPurchase {
    private static final Pattern REGEX_NUMERIC = Pattern.compile("^[0-9]\\d*$");

    private int lottoPurchaseCount;

    public LottoPurchase(String inputNumber) {
        setLottoPurchaseCount(inputNumber);
    }

    public static void validateInputTypeNumeric(String inputNumber) {
        if (!REGEX_NUMERIC.matcher(inputNumber).matches()) {
            throw new IllegalArgumentException(ERROR_NUMERIC_TYPE);
        }
    }

    public static void validateMinimunPrice(int totalPrice) {
        if (totalPrice < LOTTO_PER_PRICE) {
            throw new IllegalArgumentException(ERROR_MINIMUM_PRICE);
        }
    }

    public static void validateDivideLottoPrice(int totalPrice) {
        if ((totalPrice % LOTTO_PER_PRICE) != 0) {
            throw new IllegalArgumentException(ERROR_NOT_DIVIDE_LOTTO_PRICE);
        }
    }

    private int getLottoPurchaseCount(int totalPrice) {
        return totalPrice / LOTTO_PER_PRICE;
    }

    private void setLottoPurchaseCount(String inputNumber) {
        validateInputTypeNumeric(inputNumber);
        int totalPrice = Integer.parseInt(inputNumber);
        validateMinimunPrice(totalPrice);
        validateDivideLottoPrice(totalPrice);
        this.lottoPurchaseCount = getLottoPurchaseCount(totalPrice);
    }
}