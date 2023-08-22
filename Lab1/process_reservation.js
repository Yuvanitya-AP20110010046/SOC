document.addEventListener("DOMContentLoaded", function () {
    const submitBtn = document.getElementById("submitBtn");
    submitBtn.addEventListener("click", saveReservationData);
});

function saveReservationData() {
    const Name = document.getElementById("name").value;
    const Phone = document.getElementById("phone").value;
    const Date = document.getElementById("date").value;
    const Address = document.getElementById("address").value;
    const Account = document.getElementById("account").value;


    const xmlString = `
    <details>
    <fullName name='${Name}' >
    <phone value='${Phone}'></phone>
    <date value ='${Date}' ></date>
    <address value = '${Address}'></address>
    <account value = '${Account}'></account>
    </fullName>
</details>

    `;

    const blob = new Blob([xmlString], { type: "application/xml" });
    const link = document.createElement("a");
    link.href = URL.createObjectURL(blob);
    link.download = "details (1).xml";
    link.click();
}