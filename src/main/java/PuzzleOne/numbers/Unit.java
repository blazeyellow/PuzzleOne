package PuzzleOne.numbers;

import PuzzleOne.NumberPrinter;
import PuzzleOne.NumberSection;
import PuzzleOne.numbers.type.NumberType;

public class Unit implements Number {

    private Integer unit;
    private NumberSection numberSection;

    public Unit(NumberSection numberSection, Integer integer) {
        this.unit = integer;
        this.numberSection = numberSection;

    }

    public Integer getUnit() {
        return unit;
    }

    @Override
    public String read() {
        if (numberSection.getTen().getTen()>1 && unit.equals(0)) {
            // we have a ten but no unit so nothing to display
            return NumberPrinter.empty();

        } else if ((numberSection.getTen().getTen()==1 && unit>0)
                || numberSection.getTen().getTen()>1 && unit==0) {
//            we have a teen (10->19)
            return NumberPrinter.empty();

        } else if (numberSection.getBigNumber().getNumberSections().size()==1
                && numberSection.getHundred().getUnit().equals(0)
                && numberSection.getTen().getTen().equals(0)
                && unit.equals(0)) {
            // we have 0
            return NumberPrinter.format(NumberType.UnitNumber.Zero.name());

        } else if ((numberSection.getHundred().getUnit()>0
                || numberSection.getTen().getTen()>0)
                && unit==0) {
            return NumberPrinter.empty();

        } else if (numberSection.getBigNumber().getNumberSections().size()>1
                && unit.equals(0)) {
            return NumberPrinter.empty();

        } else {
            return NumberPrinter.format(NumberType.UnitNumber.getLabel(unit).name());

        }
    }
}
