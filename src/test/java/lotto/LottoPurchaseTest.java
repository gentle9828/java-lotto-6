package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.model.LottoPurchase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoPurchaseTest {

    @DisplayName("입력한 구입 금액이 숫자인지 검증한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-13000", "1.53", "0.555", "asdf"})
    void validateByNumericType(String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoPurchase.validateInputTypeNumeric(input));
    }

    @DisplayName("입력한 구입 금액이 1000원 이상인지 검증한다.")
    @Test
    void validateByMinimumPrice() {
        int price = 700;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoPurchase.validateMinimunPrice(price));
    }

    @DisplayName("입력한 구입 금액이 1000원으로 나누어지는지 검증한다.")
    @Test
    void validateDivideBy1000() {
        int price = 7777;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoPurchase.validateDivideLottoPrice(price));
    }

    @DisplayName("구입 금액 입력에 대한 유효성 검증 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"700", "7777", "7700", "Asdf"})
    void validateLottoPurchase(String input) {
        assertThatThrownBy(() -> new LottoPurchase(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("구입 금액에 대한 로또 구입 수량 검증 테스트")
    @Test
    void validateGetLottoPurchaseCount() {
        LottoPurchase lottoPurchase = new LottoPurchase("7000");
        assertThat(7).isEqualTo(lottoPurchase.getLottoCount());
    }

}
