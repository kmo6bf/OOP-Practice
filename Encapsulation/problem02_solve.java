public class Rental {
    private Movie movie;
    private int daysRented;

    public int getFrequentRenterPoints() {
        if (movie.getPriceCode() == Movie.NEW_RELEASE && daysRented > 1)
            return 2;
        else
            return 1;
    }

    ...
}

public class Movie {
    public static int REGULAR = 0;
    public static int NEW_RELEASE = 1;
    private int priceCode;

    public int getPriceCode() {
        return priceCode;
    }

    ...
}