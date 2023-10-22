import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FilterFlights;
import com.gridnine.testing.service.InfoService;
import com.gridnine.testing.service.impl.FilterFlightsImpl;
import com.gridnine.testing.util.FlightBuilder;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        Scanner scanner = new Scanner(System.in);

        InfoService.printInfo(flights);

        FilterFlights filterFlights = new FilterFlightsImpl();

        while (true) {
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    InfoService.printInfo(filterFlights.departureBeforeMomentTime(flights, LocalDateTime.now()));
                    break;
                case "2":
                    InfoService.printInfo(filterFlights.arrivalDateBeforeDepartureDate(flights));
                    break;
                case "3":
                    InfoService.printInfo(filterFlights.downtimeMoreTwoHours(flights));
                    break;
                case "0":
                    return;
            }
        }
    }
}
