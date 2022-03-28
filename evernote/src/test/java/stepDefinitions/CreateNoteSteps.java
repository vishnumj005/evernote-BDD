package stepDefinitions;

import static org.testng.Assert.assertTrue;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import cucumber.api.java.en.Then;
import pageObjects.CreateNoteObjects;

public class CreateNoteSteps {

    CreateNoteObjects note = new CreateNoteObjects();

    @Then("^user clicks on create note$")
    public void clickCreateNote() throws InterruptedException {
        note.clickCreateNote();
    }
    @Then("^add title \"([^\"]*)\" and content \"([^\"]*)\"$")
    public void add_title_and_content(String title, String desc) throws InterruptedException {
        note.addNoteDetails(title, desc);
    }
    @Then("^click on the existing note$")
    public void viewNote() throws InterruptedException {
        note.viewNote();
    }
    @Then("^verify title \"([^\"]*)\" in the dashboard$")
    public void verify_title_in_the_dashboard(String title) throws InterruptedException, UnsupportedFlavorException, IOException {
        assertTrue(note.verifyTitle(title), "Title Verified Successfully");

    }
}