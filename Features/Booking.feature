Feature: All bookings.com scenarios


  https://www.booking.com/searchresults.en-gb.html?ss=Goa%2C+India&label=gog235jc-1FCAEoggI46AdIM1gDaGyIAQGYATG4ARfIAQzYAQHoAQH4AQqIAgGoAgO4AqCxsZ0GwAIB0gIkYjlhNTBmNWEtZDEzMS00OGU5LTlkZGEtNTBiOTZkZWU1YTE42AIF4AIB&sid=13add8f67e8c446f6fdd416bd7f910c0&aid=397594&lang=en-gb&sb=1&src_elem=sb&src=index&dest_id=4127&dest_type=region&checkin=2023-12-28&checkout=2023-12-29&group_adults=2&no_rooms=1&group_children=0&sb_travel_purpose=leisure




# 1
  @starverify
  Scenario Outline: Verify user can only view the result by selected property class
    Given I am on default locations search result screen
    When I select option for stars as <stars>
    Then I verify system displays only <stars> hotels on search result
    Examples:
      | stars   |
    #  | 5 stars |
      | 4 stars |
    #  | 3 stars |




#2


  @maxAmount
  Scenario: check the hotel prices are below a certain amount
    Given I am on default locations search result screen
    Then I verify system displays all hotels within "20000" amount




#3
  @hotelsSearch
  Scenario: verify given hotel is present in the list
    Given I am on default locations search result screen
    Then I verify "Orchid Hotel" is within the search result
