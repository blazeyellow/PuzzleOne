package PuzzleOne.numbers;

import PuzzleOne.NumberPrinter;
import PuzzleOne.NumberSection;
import PuzzleOne.numbers.type.NumberType;

public class Hundred implements Number {

    private Integer unit;
    private NumberSection numberSection;

    public Hundred(NumberSection ns, Integer no) {
        this.unit = no;
        this.numberSection = ns;

    }

    public Integer getUnit() {
        return unit;
    }

    @Override
    public String read() {

        if (unit!=null && !unit.equals(0)) {
            return NumberPrinter.format(NumberType.UnitNumber.getLabel(unit) + " Hundred"
                    + (numberSection.hasTens() || numberSection.hasUnits() ? " and" : ""));

        } else {
            return "";

        }
    }
}
