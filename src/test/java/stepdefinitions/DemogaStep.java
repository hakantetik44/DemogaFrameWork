package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import pages.DemogaPage;
import utilities.Driver;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static utilities.Driver.scrollToElement;
import static utilities.Driver.waitForVisibility;

public class DemogaStep {

    DemogaPage demogaPage = new DemogaPage();

    Actions action = new Actions(Driver.getDriver());




    @Given("Naviguer  se rend sur l'url {string}")
    public void naviguer_se_rend_sur_l_url(String url) {

        Driver.getDriver().get(url);

    }

    @Given("Choisir n’importe quel article et le sélectionner")
    public void choisir_n_importe_quel_article_et_le_sélectionner() throws InterruptedException {

           action.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).click().perform();
           demogaPage.Article.click();

    }

    @Given("Choisir une option couleur \\(Color) et une option taille \\(Size)")
    public void choisir_une_option_couleur_Color_et_une_option_taille_Size() throws InterruptedException {
        Thread.sleep(2000);
        Select select = new Select(demogaPage.colorArticle);
        select.selectByValue("mauve");
        Select select2 = new Select(demogaPage.sizeArticle);
        select2.selectByValue("medium");

    }

    @Given("Cliquer sur le bouton ADD TO CART")
    public void cliquer_sur_le_bouton_ADD_TO_CART() throws InterruptedException {
        demogaPage.AddToCart.click();
    }

    @Given("Un message de succès doit s’afficher : “article_name” has been added to your cart")
    public void un_message_de_succès_doit_s_afficher_article_name_has_been_added_to_your_cart() {
        Assert.assertTrue(demogaPage.articleName.isDisplayed());
    }

    @Given("Cliquer ensuite sur le bouton « View cart »")
    public void cliquer_ensuite_sur_le_bouton_View_cart() throws InterruptedException {
        Thread.sleep(2000);
        demogaPage.viewCart.click();
    }

    @Given("L’article doit se rajouter dans le panier, et le total de prix doit s’afficher dans le panier en haut.")
    public void l_article_doit_se_rajouter_dans_le_panier_et_le_total_de_prix_doit_s_afficher_dans_le_panier_en_haut() {
        Assert.assertTrue(demogaPage.totalPrice.isDisplayed());
    }

    @Given("Cliquer sur le bouton « Proceed to checkout »")
    public void cliquer_sur_le_bouton_Proceed_to_checkout() throws InterruptedException {

        scrollToElement(demogaPage.buttonProceed);
        demogaPage.buttonProceed.click();

    }

    @Given("Un formulaire de payement doit s’afficher")
    public void un_formulaire_de_payement_doit_s_afficher() {

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(demogaPage.billingDetails.isDisplayed());
        softAssert.assertAll();
    }

    @Given("Remplir tous les champs obligatoires du formulaire à savoir le nom, le prénom, le pays, l’adresse, le numéro de téléphone, l’adresse mail, et cocher la case « I HAVE READ AND AGREE TO THE WEBSITE TERMS AND CONDITIONS »")
    public void remplir_tous_les_champs_obligatoires_du_formulaire_à_savoir_le_nom_le_prénom_le_pays_l_adresse_le_numéro_de_téléphone_l_adresse_mail_et_cocher_la_case_I_HAVE_READ_AND_AGREE_TO_THE_WEBSITE_TERMS_AND_CONDITIONS() {
        demogaPage.firstName.sendKeys("hakan");
        demogaPage.lastName.sendKeys("tetik");
        demogaPage.company.sendKeys(Keys.TAB);
        demogaPage.drop.click();
        demogaPage.dropdownCountry.sendKeys("France" + Keys.ENTER);
        demogaPage.StreetAddress.sendKeys("rue des simon");
        demogaPage.StreetAddress2.sendKeys("43.billing adres ");
        demogaPage.postcode.sendKeys("42000");
        demogaPage.billingCity.sendKeys("paris");
        demogaPage.billingPhone.sendKeys("09043435834");
        demogaPage.billingEmail.sendKeys("lionel@gmail.com");
        demogaPage.check.click();


    }

    @Then("Cliquer ensuite sur le bouton «PLACE ORDER »")
    public void cliquer_ensuite_sur_le_bouton_PLACE_ORDER() {
        demogaPage.buttonPlaceOrder.click();

    }

    @Then("Un message de succès doit s’afficher avec les détails de la commande d’achat.")
    public void un_message_de_succès_doit_s_afficher_avec_les_détails_de_la_commande_d_achat() {

        Assert.assertTrue(demogaPage.successMessage.isDisplayed());
        System.out.println(demogaPage.successMessage.getText());

    }

}
