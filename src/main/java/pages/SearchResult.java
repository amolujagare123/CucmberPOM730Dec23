package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

import static stepdefinition.SharedSD.getDriver;

public class SearchResult extends Base{

    By crossButton = By.xpath("//button[contains(@aria-label,'Dismiss')]");
    By rawPrices = By.xpath("//span[@data-testid='price-and-discounted-price']");

    By hotels = By.xpath("//div[@data-testid='title']");

    public ArrayList<String> getHotelList()
    {
        return getElementTextList(hotels);
    }

    public ArrayList<Integer> getAllPrices()
    {
        ArrayList<Integer> priceList = new ArrayList<>();
        ArrayList<String> wbListPrices = getElementTextList(rawPrices); // ₹ 7,058
        for (String priceStr:wbListPrices)
        {
           // System.out.println(priceStr); // ₹ 7,058

            String priceWithComma = priceStr.split(" ")[1];
         //   System.out.println(priceWithComma); // 7,058

       //     String priceWithoutComma =priceWithComma.split(",")[0]+ priceWithComma.split(",")[1];

            String priceWithoutComma = priceWithComma.replace(",","");
            System.out.println(priceWithoutComma);

            priceList.add(Integer.parseInt(priceWithoutComma));
        }

        return priceList;
    }

    public void clickCrossButton()
    {
        clickOn(crossButton);
    }

    public void clickRating(String star) // 5
    {
       By rating =  By.xpath("//input[@name='class="+star+"']");
       clickOn(rating);
    }

    By totalRatingElement = By.xpath("//div[@data-testid='rating-stars']");
    By totalStarsElement = By.xpath("//div[@data-testid='rating-stars']/span");

    public int getStarRating()
    {
        int totalRating = getDriver().findElements(totalRatingElement).size();
        int totalStars = getDriver().findElements(totalStarsElement).size();

        return (totalStars / totalRating);
    }
}
