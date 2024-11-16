package test.playwright.flow.pageflows;

import test.playwright.page.pages.ElementsPage;

public class ElementsPageFlow extends ElementsPage {
    private TextBoxSection textBoxSection;
    private CheckBoxSection checkBoxSection;
    public ElementsPageFlow() {
        textBoxSection = new TextBoxSection();
        checkBoxSection = new CheckBoxSection();
    }

    public void completeTextBoxFormSubmission(final String fullName, final String email, final String currentAddress, final String permanentAddress) {
         textBoxSection.fillFullName(fullName);
         textBoxSection.fillEmail(email);
         textBoxSection.fillCurrentAddress(currentAddress);
         textBoxSection.fillPermanentAddress(((permanentAddress == null) ? currentAddress : permanentAddress));
         textBoxSection.clickOnSubmit();
    }


    public void checkHome() {
        checkBoxSection.checkHome();
    }

    public void expandCheckBox() {
        checkBoxSection.expandCheckBox();
    }

    public void uncheckDesktop() {
        checkBoxSection.uncheckDesktop();
    }
}
