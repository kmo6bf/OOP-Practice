public class Rental {
    private Movie movie;
    private int daysRented;

    public int getFrequentRenterPoints() {
        // 아예 해당 메서드를 통째로 Movie 클래스에 정의해준다.
        return movie.getFrequentRenterPoints(daysRented);
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

    // 리턴하는 포인트의 값이 변경되더라도 캡슐화한 Movie클래스만 변경해주면 되므로 편리하다.
    // 데이터를 들고있는 쪽에 기능을 추가하면서 기능을 구현하는데 필요한 다른값을 파라미터로 받는 예시이다.
    public int getFrequentRenterPoints(int daysRented) {
        if (priceCode == NEW_RELEASE && daysRented > 1)
            return 2;
        else
            return 1;
    }

    ...
}