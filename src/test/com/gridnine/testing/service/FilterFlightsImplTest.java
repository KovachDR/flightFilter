package test.com.gridnine.testing.service;

import com.gridnine.testing.model.Flight;
import com.gridnine.testing.service.FilterFlights;
import com.gridnine.testing.service.impl.FilterFlightsImpl;
import com.gridnine.testing.util.FlightBuilder;
import junit.framework.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

public class FilterFlightsImplTest {
    private final FilterFlights filterFlights = new FilterFlightsImpl();
    private final FlightBuilder flightBuilder = new FlightBuilder();
    private final List<Flight> flights = flightBuilder.createFlights();

    @Test
    public void departureBeforeMomentTime() {
        Assert.assertNotNull(flights);
        Assert.assertEquals(1, filterFlights.departureBeforeMomentTime(flights, LocalDateTime.now()).size());
    }

    @Test
    public void arrivalDateBeforeDepartureDate() {
        Assert.assertNotNull(flights);
        Assert.assertEquals(1, filterFlights.arrivalDateBeforeDepartureDate(flights).size());
    }

    @Test
    public void downtimeMoreTwoHours() {
        Assert.assertNotNull(flights);
        Assert.assertEquals(2, filterFlights.downtimeMoreTwoHours(flights).size());
    }
}
