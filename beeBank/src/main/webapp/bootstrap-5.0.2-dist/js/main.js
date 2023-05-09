//Get Transaction Type
const transactType = document.querySelector("#transact-type");

//Get Transaction Forms:
const paymentCard = document.querySelector(".payment-card");
const transferCard = document.querySelector(".transfer-card");
const depositCard = document.querySelector(".deposit-card");
const withdrawalCard = document.querySelector(".withdrawal-card");


transactType.addEventListener("change", function(){
    //Check for transaction type and display form:
    switch(transactType.value){
        case "payment":
            paymentCard.style.display = "block";
            paymentCard.nextElementSibling.style.display = "none";
        break;

        case "transfer":
            transferCard.previousElementSibling.style.display = "none";
            transferCard.style.display = "block"
            // transferCard.nextElementSibling.style.display = "none";
        break;
    }
})