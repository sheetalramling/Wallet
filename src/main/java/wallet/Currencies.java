package wallet;

public enum Currencies {
    USD {
        @Override
        public String toString() {
            return "USD";
        }
    },

    INR {
        @Override
        public String toString() {
            return "INR";
        }


    }
}

