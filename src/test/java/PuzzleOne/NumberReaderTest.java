package PuzzleOne;

import PuzzleOne.numbers.BigNumber;
import PuzzleOne.numbers.type.NumberType;
import junit.framework.TestCase;
import org.junit.Ignore;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.fest.assertions.Assertions.assertThat;

public class NumberReaderTest extends TestCase {

    public void testCreate_0() {
        BigNumber bigNumber = new BigNumber(0);

        assertThat(bigNumber.toString()).isEqualTo("0");

    }

    public void testCreate_1234() {
        BigNumber bigNumber = new BigNumber(1234);

        assertThat(bigNumber.toString()).isEqualTo("1,234");

    }

    public void testCreate_1234567890() {
        BigNumber bigNumber = new BigNumber(1234567890);

        assertThat(bigNumber.toString()).isEqualTo("1,234,567,890");

    }

    public void testRead_0() {
        BigNumber bigNumber = new BigNumber(0);

        assertThat(bigNumber.read()).isEqualTo(NumberType.UnitNumber.Zero.name());

    }

    public void testRead_9() {
        BigNumber bigNumber = new BigNumber(9);

        assertThat(bigNumber.read()).isEqualTo(NumberType.UnitNumber.Nine.name());

    }

    public void testRead_10() {
        BigNumber bigNumber = new BigNumber(10);

        assertThat(bigNumber.read()).isEqualTo(NumberType.TenNumber.Ten.name());

    }

    public void testRead_11() {
        BigNumber bigNumber = new BigNumber(11);

        assertThat(bigNumber.read()).isEqualTo(NumberType.TeenNumber.Eleven.name());

    }

    public void testRead_19() {
        BigNumber bigNumber = new BigNumber(19);

        assertThat(bigNumber.read()).isEqualTo(NumberType.TeenNumber.Nineteen.name());

    }

    public void testRead_20() {
        BigNumber bigNumber = new BigNumber(20);

        assertThat(bigNumber.read()).isEqualTo(NumberType.TenNumber.Twenty.name());

    }

    public void testRead_21() {
        BigNumber bigNumber = new BigNumber(21);

        assertThat(bigNumber.read()).isEqualTo(NumberType.TenNumber.Twenty.name() + " " + NumberType.UnitNumber.One);

    }

    public void testRead_29() {
        BigNumber bigNumber = new BigNumber(29);

        assertThat(bigNumber.read()).isEqualTo(NumberType.TenNumber.Twenty.name() + " " + NumberType.UnitNumber.Nine);

    }

    public void testRead_30() {
        BigNumber bigNumber = new BigNumber(30);

        assertThat(bigNumber.read()).isEqualTo(NumberType.TenNumber.Thirty.name());

    }

    public void testRead_31() {
        BigNumber bigNumber = new BigNumber(31);

        assertThat(bigNumber.read()).isEqualTo(NumberType.TenNumber.Thirty.name() + " " + NumberType.UnitNumber.One);

    }

    public void testRead_39() {
        BigNumber bigNumber = new BigNumber(39);

        assertThat(bigNumber.read()).isEqualTo(NumberType.TenNumber.Thirty.name() + " " + NumberType.UnitNumber.Nine);

    }

    public void testRead_99() {
        BigNumber bigNumber = new BigNumber(99);

        assertThat(bigNumber.read()).isEqualTo(NumberType.TenNumber.Ninety.name() + " " + NumberType.UnitNumber.Nine);

    }

    public void testRead_100() {
        BigNumber bigNumber = new BigNumber(100);

        assertThat(bigNumber.read()).isEqualTo("One Hundred");

    }

    public void testRead_101() {
        BigNumber bigNumber = new BigNumber(101);

        assertThat(bigNumber.read()).isEqualTo("One Hundred and One");

    }

    public void testRead_110() {
        BigNumber bigNumber = new BigNumber(110);

        assertThat(bigNumber.read()).isEqualTo("One Hundred and Ten");

    }

    public void testRead_119() {
        BigNumber bigNumber = new BigNumber(119);

        assertThat(bigNumber.read()).isEqualTo("One Hundred and Nineteen");

    }

    public void testRead_120() {
        BigNumber bigNumber = new BigNumber(120);

        assertThat(bigNumber.read()).isEqualTo("One Hundred and Twenty");

    }

    public void testRead_121() {
        BigNumber bigNumber = new BigNumber(121);

        assertThat(bigNumber.read()).isEqualTo("One Hundred and Twenty One");

    }

    public void testRead_199() {
        BigNumber bigNumber = new BigNumber(199);

        assertThat(bigNumber.read()).isEqualTo("One Hundred and Ninety Nine");

    }

    public void testRead_200() {
        BigNumber bigNumber = new BigNumber(200);

        assertThat(bigNumber.read()).isEqualTo("Two Hundred");

    }

    public void testRead_999() {
        BigNumber bigNumber = new BigNumber(999);

        assertThat(bigNumber.read()).isEqualTo("Nine Hundred and Ninety Nine");

    }

    public void testRead_1000() {
        BigNumber bigNumber = new BigNumber(1000);

        assertThat(bigNumber.read()).isEqualTo("One Thousand");

    }

    public void testRead_1002() {
        BigNumber bigNumber = new BigNumber(1002);

        assertThat(bigNumber.read()).isEqualTo("One Thousand and Two");

    }

    public void testRead_1999() {
        BigNumber bigNumber = new BigNumber(1999);

        assertThat(bigNumber.read()).isEqualTo("One Thousand, Nine Hundred and Ninety Nine");

    }

    public void testRead_2999() {
        BigNumber bigNumber = new BigNumber(2999);

        assertThat(bigNumber.read()).isEqualTo("Two Thousand, Nine Hundred and Ninety Nine");

    }

    public void testRead_9999() {
        BigNumber bigNumber = new BigNumber(9999);

        assertThat(bigNumber.read()).isEqualTo("Nine Thousand, Nine Hundred and Ninety Nine");

    }

    public void testRead_10000() {
        BigNumber bigNumber = new BigNumber(10000);

        assertThat(bigNumber.read()).isEqualTo("Ten Thousand");

    }

    public void testRead_10001() {
        BigNumber bigNumber = new BigNumber(10001);

        assertThat(bigNumber.read()).isEqualTo("Ten Thousand and One");

    }

    public void testRead_10900() {
        BigNumber bigNumber = new BigNumber(10900);

        assertThat(bigNumber.read()).isEqualTo("Ten Thousand, Nine Hundred");

    }

    public void testRead_10999() {
        BigNumber bigNumber = new BigNumber(10999);

        assertThat(bigNumber.read()).isEqualTo("Ten Thousand, Nine Hundred and Ninety Nine");

    }

    public void testRead_99999() {
        BigNumber bigNumber = new BigNumber(99999);

        assertThat(bigNumber.read()).isEqualTo("Ninety Nine Thousand, Nine Hundred and Ninety Nine");

    }

    public void testRead_100000() {
        BigNumber bigNumber = new BigNumber(100000);

        assertThat(bigNumber.read()).isEqualTo("One Hundred Thousand");

    }

    public void testRead_999999() {
        BigNumber bigNumber = new BigNumber(999999);

        assertThat(bigNumber.read()).isEqualTo("Nine Hundred and Ninety Nine Thousand, Nine Hundred and Ninety Nine");

    }

    public void testRead_1000000() {
        BigNumber bigNumber = new BigNumber(1000000);

        assertThat(bigNumber.read()).isEqualTo("One Million");

    }

    public void testRead_1000001() {
        BigNumber bigNumber = new BigNumber(1000001);

        assertThat(bigNumber.read()).isEqualTo("One Million and One");

    }

    public void testRead_1000010() {
        BigNumber bigNumber = new BigNumber(1000010);

        assertThat(bigNumber.read()).isEqualTo("One Million and Ten");

    }

    public void testRead_1000100() {
        BigNumber bigNumber = new BigNumber(1000100);

        assertThat(bigNumber.read()).isEqualTo("One Million, One Hundred");

    }

    public void testRead_1010000() {
        BigNumber bigNumber = new BigNumber(1010000);

        assertThat(bigNumber.read()).isEqualTo("One Million, Ten Thousand");

    }

    public void testRead_1010100() {
        BigNumber bigNumber = new BigNumber(1010100);

        assertThat(bigNumber.read()).isEqualTo("One Million, Ten Thousand, One Hundred");

    }

    public void testRead_999999999() {
        BigNumber bigNumber = new BigNumber(999999999);

        assertThat(bigNumber.read()).isEqualTo("Nine Hundred and Ninety Nine Million, Nine Hundred and Ninety Nine Thousand, Nine Hundred and Ninety Nine");

    }

    public void testStuff() {
        BigNumber bigNumber = new BigNumber(555);
        bigNumber.read();

    }

    // *******************************
    // INTEGRATION TESTS...
    // *******************************

    public void testNumberReader_success() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));

        NumberReader.main(new String [] {"999999999"});

        assertThat(outContent.toString()).isEqualTo("Nine Hundred and Ninety Nine Million, Nine Hundred and Ninety Nine Thousand, Nine Hundred and Ninety Nine\n");

        System.setOut(null);
        System.setErr(null);

    }

    public void testNumberReader_no_params() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));

        NumberReader.main(new String [] {});

        assertThat(outContent.toString()).isEqualTo("Number to convert required (0 to 999,999,999)\n");

        System.setOut(null);
        System.setErr(null);

    }

    public void testNumberReader_too_many_params() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();

        System.setOut(new PrintStream(outContent));

        NumberReader.main(new String [] {"1", "2"});

        assertThat(outContent.toString()).isEqualTo("Too many parameters\n");

        System.setOut(null);
        System.setErr(null);

    }
}
