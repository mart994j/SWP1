package example.cucumber;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;

import domain.Activity;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class timeSteps {

    private ActivityHolder activityHolder;
    private Integer hours;
    GregorianCalendar StartDate;
    GregorianCalendar EndDate;


    public timeSteps(ActivityHolder activityHolder) {
        this.activityHolder = activityHolder;
    }

    @Given("the expectedAmountOfHours is {int}")
    public void theExpectedAmountOfHoursIs(Integer hours) {
        this.hours = hours;
    }

    @Given("the startWeek is {int}")
    public void theStartWeekIs(Integer startW) {
        GregorianCalendar SW = new GregorianCalendar();
        SW.set(GregorianCalendar.WEEK_OF_YEAR, startW);
        StartDate = SW;
    }

    @Given("the endWeek is {int}")
    public void theEndWeekIs(Integer endW) {
        GregorianCalendar EW = new GregorianCalendar();
        EW.set(GregorianCalendar.WEEK_OF_YEAR, endW);
        EndDate = EW;
    }

    @Then("the time per week is {double}")
    public void theTimePerWeekIs(Double pweek) {
        Activity activity = activityHolder.getActivity();
        activity = new Activity("Lærke", StartDate, EndDate, hours);
        assertEquals(pweek, activity.getTimePerWeek());
    }

}
