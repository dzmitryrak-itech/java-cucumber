package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Product;

import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckOutSteps {
    HashMap<String, Product> products = new HashMap<String, Product>();

    @cucumber.api.java.en.Given("the price of a {string} is {int}c")
    public void thePriceOfAIsC(String name, int price) {
        Product prod = new Product();
        prod.setName(name);
        prod.setPrice(price);
        prod.setCount(0);
        products.put(name, prod);
    }

    @cucumber.api.java.en.When("I checkout {int} {string}")
    public void iCheckout(int number, String name) {
        Product prod = products.get(name);
        prod.setTotal(prod.getTotal() + number * prod.getPrice());
    }

    @cucumber.api.java.en.Then("the total price should be {int}c")
    public void theTotalPriceShouldBeC(double arg0) {
        double total = 0;
        for(Product pr: products.values()){
            total += pr.getTotal();
        }
        assertThat("Total price should be correct", total, equalTo(arg0));
    }
}
