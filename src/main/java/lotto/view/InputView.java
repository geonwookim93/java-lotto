package lotto.view;

import lotto.domain.InputPrice;
import lotto.domain.LottoGameCount;
import lotto.domain.LottoNumbers;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.utils.Constants.*;

public class InputView {
    private InputPrice inputPrice;
    private static Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public InputView(InputPrice inputPrice) {
        this.inputPrice = inputPrice;
    }

    public void inputPrice() {
        System.out.println(MSG_INPUT_PRICE);
        inputPrice = new InputPrice(Integer.valueOf(scanner.next()));
        inputPrice.validateSmallestUnit();
    }

    public LottoNumbers inputLastWeekWinningNumbers() {
        System.out.println(MSG_INPUT_WINNING_NUMBER);
        String[] lastWeekWinningNumbers = scanner.next().split(COMMA);
        LottoNumbers lastWeekWinnigNumbers = new LottoNumbers(Arrays.stream(lastWeekWinningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        lastWeekWinnigNumbers.validateLottoNumbersLength();
        System.out.println();

        return lastWeekWinnigNumbers;
    }

    public LottoGameCount getLottoGameCount() {
        return new LottoGameCount(inputPrice.divideByThousands());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputView inputView = (InputView) o;
        return Objects.equals(inputPrice, inputView.inputPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputPrice);
    }
}
