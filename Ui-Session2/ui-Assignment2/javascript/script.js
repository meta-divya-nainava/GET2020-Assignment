/**
 * method to hide all forms used in index file
 */
function hideAllForms() {
    document.getElementsByClassName("employeeRegion")[0].style.display = "none";
    document.getElementsByClassName("vehicleRegion")[0].style.display = "none";
    document.getElementsByClassName("feedbackRegion")[0].style.display = "none";
    document.getElementsByClassName("pricingRegion")[0].style.display = "none";
}
hideAllForms()
    /**
     * method to show only employeeform if it is not visible else hide all forms
     */
function showEmployee() {

    if (document.getElementsByClassName("employeeRegion")[0].style.display == "block") {
        hideAllForms();
    } else {
        hideAllForms();
        document.getElementsByClassName("employeeRegion")[0].style.display = "block";
    }


}
/**
 * method to show only vehicleform if it is not visible else hide all forms
 */
function showVehicle() {

    if (document.getElementsByClassName("vehicleRegion")[0].style.display == "block") {
        hideAllForms();
    } else {
        hideAllForms();
        document.getElementsByClassName("vehicleRegion")[0].style.display = "block"
    }
}
/**
 * method to show only feedbackform if it is not visible else hide all forms
 */
function showFeedback() {
    if (document.getElementsByClassName("feedbackRegion")[0].style.display == "block") {
        hideAllForms();
    } else {
        hideAllForms();
        document.getElementsByClassName("feedbackRegion")[0].style.display = "block";
    }
}
/**
 * method to show only pricingform if it is not visible else hide all forms
 */
function showPricing() {
    if (document.getElementsByClassName("pricingRegion")[0].style.display == "block") {
        hideAllForms();
    } else {
        hideAllForms();
        document.getElementsByClassName("pricingRegion")[0].style.display = "block";
    }
}