package PuzzleOne.numbers.type;

public class NumberType {

    public enum UnitNumber {
        Zero(0), One(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9);

        int no;

        private UnitNumber(int no) {
            this.no = no;
        }

        public static UnitNumber getLabel(int no) {

            switch (no) {
                case 0 : return UnitNumber.Zero;
                case 1 : return UnitNumber.One;
                case 2 : return UnitNumber.Two;
                case 3 : return UnitNumber.Three;
                case 4 : return UnitNumber.Four;
                case 5 : return UnitNumber.Five;
                case 6 : return UnitNumber.Six;
                case 7 : return UnitNumber.Seven;
                case 8 : return UnitNumber.Eight;
                case 9 : return UnitNumber.Nine;

            }
            return null;
        }
    }

    public enum TeenNumber {
        Eleven(11), Twelve(12), Thirteen(13), Fourteen(14),
        Fifteen(15), Sixteen(16), Seventeen(17), Eighteen(18), Nineteen(19);

        int no;

        private TeenNumber(int no) {
            this.no = no;
        }

        public static TeenNumber getLabel(int no) {

            switch (no) {
                case 1 : return TeenNumber.Eleven;
                case 2 : return TeenNumber.Twelve;
                case 3 : return TeenNumber.Thirteen;
                case 4 : return TeenNumber.Fourteen;
                case 5 : return TeenNumber.Fifteen;
                case 6 : return TeenNumber.Sixteen;
                case 7 : return TeenNumber.Seventeen;
                case 8 : return TeenNumber.Eighteen;
                case 9 : return TeenNumber.Nineteen;

            }
            return null;
        }

    }

    public enum TenNumber {
        Ten(0), Twenty(2), Thirty(3), Forty(4), Fifty(5),
        Sixty(6), Seventy(7), Eighty(8), Ninety(9);

        int no;

        private TenNumber(int no) {
            this.no = no;
        }

        public static TenNumber getLabel(int no) {

            switch (no) {
                case 1 : return TenNumber.Ten;
                case 2 : return TenNumber.Twenty;
                case 3 : return TenNumber.Thirty;
                case 4 : return TenNumber.Forty;
                case 5 : return TenNumber.Fifty;
                case 6 : return TenNumber.Sixty;
                case 7 : return TenNumber.Seventy;
                case 8 : return TenNumber.Eighty;
                case 9 : return TenNumber.Ninety;

            }
            return null;
        }
    }
}
