package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SearchResult;

import java.util.ArrayList;

public class BookingSD {

    SearchResult searchResult = new SearchResult();

    @Given("I am on default locations search result screen")
    public void searchLocationPage()
    {

        try {
            searchResult.clickCrossButton();
        }
        catch (Exception e)
        {

        }
    }

    @When("^I select option for stars as (.+)$")
    public void iSelectOptionForStarsAs(String star) // "5 stars"
    {

        searchResult.clickRating(star.split(" ")[0]);
    }


    @Then("^I verify system displays only (.+) hotels on search result$")
    public void iVerifySystemDisplaysOnlyHotelsOnSearchResult(String star) // "5 star"
    {
       int expectedRating = Integer.parseInt(star.split(" ")[0]);
       int actualRating = searchResult.getStarRating();

        System.out.println("expectedRating="+expectedRating);
        System.out.println("actualRating="+actualRating);

        Assert.assertEquals("all hotels are not"+star,expectedRating,actualRating);
    }

    @Then("I verify system displays all hotels within {string} amount")
    public void iVerifySystemDisplaysAllHotelsWithinAmount(String expectedPriceStr) {

        int expectedPrice = Integer.parseInt(expectedPriceStr);
        ArrayList<Integer> priceList = searchResult.getAllPrices();
        ArrayList<Integer> greaterPriceList = new ArrayList<>();

        boolean flag = true;
        for (int price : priceList)
        {
            if(price>expectedPrice){
                flag = false;
                greaterPriceList.add(price);
            }
        }

        Assert.assertTrue("some prices are greater than "+expectedPrice
                + "\nGreater prices are\n:"+greaterPriceList
                ,flag);

    }

    @Then("I verify {string} is within the search result")
    public void iVerifyIsWithinTheSearchResult(String expectedHotel) {

        ArrayList<String> hotelList = searchResult.getHotelList();

        boolean flag = false;
        for(String hotel:hotelList)
        {
            System.out.println(hotel);
            if (hotel.contains(expectedHotel))
                flag=true;
        }

        Assert.assertTrue(expectedHotel+": this hotel is not present in the search result"
                ,flag);

    }
}
