import java.util.ArrayList;

public class MovieTicketReservation {
    public static void main(String[] args) {
        ArrayList<MovieList> movieList = new ArrayList<>();

        movieList.add(new MovieList("Avengers: End Game", 30000, "14.00", 2, "24D", 0.1));
        movieList.add(new MovieList("Minions", 30000, "17.00", 3, "17A", 0.15));
        movieList.add(new MovieList("The Lion King", 30000, "20.00", 4, "12B", 0.2));

        for (MovieList movie : movieList) {
            movie.displayInfo();
            System.out.println("-------------------");
        }
    }
}
