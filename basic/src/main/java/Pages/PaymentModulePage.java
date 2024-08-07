package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class PaymentModulePage {
        private WebDriver driver;

        // Constructor - Initialize WebDriver and elements
        public PaymentModulePage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        // Locate depositId input element
        @FindBy(xpath = "//input[@id='depositId']")
        private WebElement depositIdInput;

        // Locate depositName input element
        @FindBy(xpath = "//input[@id='depositName']")
        private WebElement depositNameInput;

        // Locate depositAmount input element
        @FindBy(xpath = "//input[@id='depositAmount']")
        private WebElement depositAmountInput;

        // Locate depositType select element
        @FindBy(xpath = "//select[@id='depositType']")
        private WebElement depositTypeSelect;

        // Locate option for Deposit in depositType select element
        @FindBy(xpath = "//option[@value='1'][normalize-space()='Deposit']")
        private WebElement depositTypeDepositOption;

        // Locate option for Withdraw in depositType select element
        @FindBy(xpath = "//option[@value='2'][normalize-space()='Withdraw']")
        private WebElement depositTypeWithdrawOption;

        // Locate currencyId select element
        @FindBy(xpath = "//select[@id='currencyId']")
        private WebElement currencyIdSelect;

        // Locate option for a specific currency in currencyId select element
        @FindBy(xpath = "//option[@value='6687ad11fd30994303056038']")
        private WebElement currencyOption;

        // Locate Submit button element
        @FindBy(xpath = "//button[normalize-space()='Submit']")
        private WebElement submitButton;


        @FindBy(xpath = "//span[normalize-space()='Oppi Wallet']")
        private WebElement paymentModule;

        @FindBy(xpath = " //*[@for='amount']")
        private WebElement validationMsgOppi;

        // Locate currency select element
        @FindBy(xpath = "//select[@name='currency']")
        private WebElement currencySelect;

        // Locate option for TRX currency in currency select element
        @FindBy(xpath = "//option[@value='TRX']")
        private WebElement trxCurrencyOption;

        // Locate Amount input field
        @FindBy(xpath = "//input[@placeholder='Amount']")
        private WebElement amountInput;

        // Locate Pay button element
        @FindBy(xpath = "//button[normalize-space()='Pay']")
        private WebElement payButton;


        @FindBy(xpath = "//*[@class='copy_input']")
        WebElement qrCodeCopy;

        @FindBy(xpath = "//*[normalize-space()='Paymorh (Credit Card)'][@class='title text-sm']")
        WebElement creditCard;


        @FindBy(xpath = "//*[@class=\"title text-sm\"][normalize-space()='Bank Transfer']")
        WebElement bankTransfer;


        @FindBy(xpath = "//*[@for='radio-57']")
        WebElement selectBank;


        @FindBy(id = "first-name")
        WebElement firstNameInput;

        @FindBy(id = "last-name")
        WebElement lastNameInput;




        @FindBy(name = "username")
        WebElement usernameInput;

        @FindBy(name = "full_name")
        WebElement fullNameInput;

        @FindBy(name = "citizenship")
        WebElement citizenshipInput;

        @FindBy(name = "birthyear")
        WebElement birthyearInput;

        @FindBy(name = "card_number")
        WebElement cardNumberInput;

        @FindBy(name = "card_holdername")
        WebElement cardHolderNameInput;

        @FindBy(name = "expirationDate")
        WebElement expirationDateInput;

        @FindBy(name = "card_cvv")
        WebElement cardCvvInput;

      /*  @FindBy(xpath = "//button[normalize-space()='Pay']")
        WebElement payButton;
*/



        public void selectCreditCard() {
            creditCard.click();
        }


        public void enterUsername(String username) {
            usernameInput.sendKeys(username);
        }

        public void enterFullName(String fullName) {
            fullNameInput.sendKeys(fullName);
        }

        public void enterCitizenship(String citizenship) {
            citizenshipInput.sendKeys(citizenship);
        }

        public void enterBirthyear(String birthyear) {
            birthyearInput.sendKeys(birthyear);
        }

        public void enterCardNumber(String cardNumber) {
            cardNumberInput.sendKeys(cardNumber);
        }

        public void enterCardHolderName(String cardHolderName) {
            cardHolderNameInput.sendKeys(cardHolderName);
        }

        public void enterExpirationDate(String expirationDate) {
            expirationDateInput.sendKeys(expirationDate);
        }

        public void enterCardCvv(String cardCvv) {
            cardCvvInput.sendKeys(cardCvv);
        }



        // Method to set depositId input field
        public void setDepositId(String depositId) {
            depositIdInput.sendKeys(depositId);
        }

        // Method to set depositName input field
        public void setDepositName(String depositName) {
            depositNameInput.sendKeys(depositName);
        }

        // Method to set depositAmount input field
        public void setDepositAmount(String depositAmount) {
            depositAmountInput.sendKeys(depositAmount);
        }

        // Method to select deposit type (Deposit or Withdraw)
        public void selectDepositType(String type) throws InterruptedException {
            if (type.equalsIgnoreCase("Deposit")) {
                depositTypeSelect.click();
               // Thread.sleep(1000);
                depositTypeDepositOption.click();
            } else if (type.equalsIgnoreCase("Withdraw")) {
                depositTypeSelect.click();
               // Thread.sleep(1000);
                depositTypeWithdrawOption.click();
            } else {
                throw new IllegalArgumentException("Invalid deposit type provided.");
            }
        }

        public String setValidationMsgOppi() {
           String errorMsg=validationMsgOppi.getText();
           return errorMsg;

        }

        // Method to select currency
        public void selectCurrency(String currencyValue) throws InterruptedException {
            currencyIdSelect.click();
            Thread.sleep(1000);
            // Assuming currencyValue matches the value attribute of the option element
            // You can customize this logic based on how you want to select the currency
            currencyOption.click();
        }

        // Method to submit the form
        public void submitForm() {
            submitButton.click();
        }

        public void paymentModuleSelect() throws InterruptedException {
            Thread.sleep(3000);
            paymentModule.click();
        }

        public void setBankTransfer(){
            bankTransfer.click();
        }

        public void setSelectBank(){
            selectBank.click();
        }

        public void enterBTFirstName(String firstName) {
            firstNameInput.sendKeys(firstName);
        }

        public void enterBTLastName(String lastName) {
            lastNameInput.sendKeys(lastName);
        }



        // Method to select currency
        public void selectCurrencyIframe(String currencyValueIframe) throws InterruptedException {
            Thread.sleep(1000);
            currencySelect.click();
            Thread.sleep(1000);
            // Assuming currencyValue matches the value attribute of the option element
            // You can customize this logic based on how you want to select the currency
            trxCurrencyOption.click(); // Change to appropriate option if value is dynamic
        }

        // Method to enter amount
        public void enterAmount(String amount) {
            amountInput.sendKeys(amount);
        }

        // Method to submit payment
        public void clickPayButton() {
            payButton.click();
        }

        public void getQrCodeCopy() {
            String qrcode=qrCodeCopy.getAttribute("value");
            System.out.println(qrcode);
        }





    }



