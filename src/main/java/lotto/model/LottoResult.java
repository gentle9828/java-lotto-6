package lotto.model;

import static lotto.model.LottoRanking.FIFTH;
import static lotto.model.LottoRanking.FIRST;
import static lotto.model.LottoRanking.FORTH;
import static lotto.model.LottoRanking.SECOND;
import static lotto.model.LottoRanking.THIRD;

import java.util.List;

public class LottoResult {

    public static int matchResult(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int match = 0;
        for (int lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                match++;
            }
        }
        return match;
    }

    public static int checkBonusNumber(List<Integer> lottoNumbers, int match, int bonusNumber) {
        if (match == SECOND.getMatchCount() && lottoNumbers.contains(bonusNumber)) {
            return match * 7;
        }
        return match;
    }

    public static void addCount(int match) {
        if (match == FIRST.getMatchCount()) {
            LottoRanking.addCount(FIRST);
        }
        if (match == SECOND.getMatchCount()) {
            LottoRanking.addCount(SECOND);
        }
        if (match == THIRD.getMatchCount()) {
            LottoRanking.addCount(THIRD);
        }
        if (match == FORTH.getMatchCount()) {
            LottoRanking.addCount(FORTH);
        }
        if (match == FIFTH.getMatchCount()) {
            LottoRanking.addCount(FIFTH);
        }
    }

}
