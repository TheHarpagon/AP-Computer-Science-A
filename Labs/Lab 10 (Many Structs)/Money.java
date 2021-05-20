public class Money {
    int dollars;
    int cents;
    
    Money () {
        this.dollars = 0;
        this.cents = 0;
    }

    Money (int amount) {
        this.dollars = amount / 100;
        this.cents = amount % 100;
    }

    Money (int amount1, int amount2) {
        this.dollars = amount1;
        this.cents = amount2;
    }
}