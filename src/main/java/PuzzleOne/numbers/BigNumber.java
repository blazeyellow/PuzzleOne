package PuzzleOne.numbers;

import PuzzleOne.NumberSection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BigNumber implements Number {

    private Sign sign;
    private List<NumberSection> numberSections;

    public enum NumberSectionName {
        Thousand(2), Million(3), Billion(4), Trillion(5);

        int no;

        private NumberSectionName(int no) {
            this.no = no;
        }

        public static NumberSectionName getLabel(int no) {

            switch (no) {
                case 2 : return NumberSectionName.Thousand;
                case 3 : return NumberSectionName.Million;
                case 4 : return NumberSectionName.Billion;
                case 5 : return NumberSectionName.Trillion;
            }

            return null;

        }
    }
    public BigNumber(Integer number) {

        sign = number<0 ? Sign.MINUS : Sign.PLUS;

        String numberStr = String.valueOf(Math.abs(number));

        String [] numberArr = splitNumber(numberStr);

        StringBuffer sb = new StringBuffer();

        numberSections = new ArrayList<NumberSection>();
        for (int i=numberArr.length-1; i>=0; i--) { // end at 1 not 0 as 0 not a number
            sb.append(numberArr[i]);

            if (sb.length()==3) {
                sb.reverse();

                NumberSection ns = new NumberSection(sb.toString());
                ns.setBigNumber(this);
                numberSections.add(ns);

                sb = new StringBuffer();

            } else if (i==0) {
                sb.reverse();

                NumberSection ns = new NumberSection(sb.toString());
                ns.setBigNumber(this);
                numberSections.add(ns);

            }
        }

        Collections.reverse(numberSections);

    }

    /**
     *
     * TODO Interestingly enough, running an example on the command line renders a different result from running in
     * the unit tests provided and also running in an IDE. Even though the incoming number is validated and converted to an
     * Integer, then Stringified and split, when running in an IDE or in a unit test, the first position in the
     * subsequent String [] is an empty string. This is never the case when running on the command line via an
     * executable jar.
     *
     * @param numberStr
     * @return
     */
    private String[] splitNumber(String numberStr) {
        String [] numberArr = numberStr.split("");

        if ("".equals(numberArr[0])) {
            return Arrays.copyOfRange(numberArr, 1, numberArr.length);

        }

        return numberArr;

     }

    public String read() {

        StringBuffer sb = new StringBuffer();
        int noOfNamedNumberSections = numberSections.size();
        int index = 0;
        for (NumberSection numberSection : numberSections) {
            sb.append(numberSection.read());

            if (noOfNamedNumberSections>1 && numberSection.hasDigitsInSection()) {
                sb.append(NumberSectionName.getLabel(noOfNamedNumberSections));
                sb.append(addWordJoiner(index, noOfNamedNumberSections));

            }

            noOfNamedNumberSections--;
            index++;

        }

        return sb.toString().trim();

    }

    private String addWordJoiner(int index, int noOfNamedNumberSections) {

        // if at the penultimate number section and last number section has no digits
        if (noOfNamedNumberSections==2 && !numberSections.get(numberSections.size()-1).hasDigitsInSection()) {
            return "";

        // if at the penultimate number section and last number section has no hundreds
        } else if (noOfNamedNumberSections==2 && !numberSections.get(numberSections.size()-1).hasHundreds()) {
            return " and ";

        } else {

            for (int i=index+1; i<numberSections.size(); i++) {
                if (!numberSections.get(i).hasDigitsInSection()) {
                    continue;

                } else {
                    if (i==numberSections.size()-1 && !numberSections.get(i).hasHundreds()) {
                        return " and ";

                    } else {
                        return ", ";

                    }
                }
            }
        }

        return " ";

    }

    public List<NumberSection> getNumberSections() {
        return numberSections;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();

        Iterator it = numberSections.iterator();
        while (it.hasNext()) {
            sb.append(((NumberSection) it.next()).toString());

            if (it.hasNext()) {
                sb.append(",");

            }
        }

        return sb.toString();

    }
}
