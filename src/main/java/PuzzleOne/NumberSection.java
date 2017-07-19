package PuzzleOne;

import PuzzleOne.numbers.BigNumber;
import PuzzleOne.numbers.Hundred;
import PuzzleOne.numbers.Number;
import PuzzleOne.numbers.Ten;
import PuzzleOne.numbers.Unit;

import java.util.ArrayList;
import java.util.List;

public class NumberSection implements Number {

    private List<Number> numberSection = new ArrayList<Number>(3);
    private BigNumber bigNumber;

    public NumberSection(String numberStr) {

        if (numberStr.length()>2) {
            numberSection.add(new Hundred(this, Integer.parseInt(numberStr.substring(numberStr.length()-3, numberStr.length()-2))));
            numberSection.add(new Ten(this, Integer.parseInt(numberStr.substring(numberStr.length()-2, numberStr.length()-1))));
            numberSection.add(new Unit(this, Integer.parseInt(numberStr.substring(numberStr.length()-1, numberStr.length()))));

        } else if (numberStr.length()>1) {
            numberSection.add(new Hundred(this, 0));
            numberSection.add(new Ten(this, Integer.parseInt(numberStr.substring(numberStr.length()-2, numberStr.length()-1))));
            numberSection.add(new Unit(this, Integer.parseInt(numberStr.substring(numberStr.length()-1, numberStr.length()))));

        } else {
            numberSection.add(new Hundred(this, 0));
            numberSection.add(new Ten(this, 0));
            numberSection.add(new Unit(this, Integer.parseInt(numberStr.substring(numberStr.length()-1, numberStr.length()))));

        }
    }

    public Hundred getHundred() {
        return (Hundred)numberSection.get(0);

    }

    public Ten getTen() {
        return (Ten)numberSection.get(1);

    }

    public Unit getUnit() {
        return (Unit)numberSection.get(2);

    }

    public BigNumber getBigNumber() {
        return bigNumber;
    }

    public void setBigNumber(BigNumber bigNumber) {
        this.bigNumber = bigNumber;
    }

    public String read() {
        StringBuffer sb = new StringBuffer();

        for (Number number : numberSection) {
            sb.append(number.read());

        }

        return sb.toString();
    }

    @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();

        if (hasHundreds()) {
            sb.append(getHundred().getUnit());
            sb.append(getTen().getTen());
            sb.append(getUnit().getUnit());

        } else if (hasTens()) {
            sb.append(getTen().getTen());
            sb.append(getUnit().getUnit());

        } else {
            sb.append(getUnit().getUnit());

        }

        return sb.toString();

    }

    public boolean hasHundreds() {
        return ((Hundred)numberSection.get(0)).getUnit()>0;

    }

    public boolean hasTens() {
        return ((Ten)numberSection.get(1)).getTen()>0;

    }

    public boolean hasUnits() {
        return ((Unit)numberSection.get(2)).getUnit()>0;

    }

    public boolean hasDigitsInSection() {
        return hasHundreds() || hasTens() || hasUnits();

    }
}
