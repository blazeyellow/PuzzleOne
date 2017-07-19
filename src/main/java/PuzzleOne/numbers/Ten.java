package PuzzleOne.numbers;

import PuzzleOne.NumberPrinter;
import PuzzleOne.NumberSection;
import PuzzleOne.numbers.type.NumberType;

public class Ten implements Number {

    private Integer ten;
    private NumberSection numberSection;

    public Ten(NumberSection numberSection, Integer integer) {
        this.ten = integer;
        this.numberSection = numberSection;

    }

    public Integer getTen() {
        return ten;
    }

    @Override
    public String read() {
        if (ten!=null && ten==1 && numberSection!=null && numberSection.getUnit().getUnit()>0) {
            return NumberPrinter.format(NumberType.TeenNumber.getLabel(numberSection.getUnit().getUnit()).name());

        } else if (ten!=null && ten>0) {
            return NumberPrinter.format(NumberType.TenNumber.getLabel(ten).name());

        }

        return NumberPrinter.empty();

    }
}
