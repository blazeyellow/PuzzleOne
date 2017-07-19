package PuzzleOne;

import PuzzleOne.numbers.BigNumber;

public class NumberReader {
    public static void main( String[] args ) {

        if (args==null || args.length==0) {
            System.out.println("Number to convert required (0 to 999,999,999)");
            return;

        }

        if (args.length>1) {
            System.out.println("Too many parameters");
            return;

        }

        Integer number = null;
        String argument = args[0].replaceAll(",", "");
        try {
            number = Integer.parseInt(argument);

        } catch (NumberFormatException e) {}

        if (number==null || number<0 || number>999999999) {
            System.out.println("Not a valid number (0 to 999,999,999)");
            return;

        }
        System.out.println(convert(number));

    }

    public static String convert(int integer) {

        PuzzleOne.numbers.Number number = new BigNumber(integer);
        return number.read();

    }
}
