const URL = "http://localhost:8081/";

let buttonRow = document.getElementById("buttonRow");
let reimbButton = document.createElement("button");
let userButton = doucment.createElement("button");
let addReimbButton = document.getElementById("addReimbButton");
let loginButton = document.getElementById('loginButton');

reimbButton.onclick = getAllReimbs;
userButton.onclick = getAllUsers;
addReimbButton.onclick = addReimb;
loginButton.onclick = loginToApp;

reimbButton.innerText = "See All Reimbursements";
userButton.innerText = "See All Users";

async function loginToApp() {
    let user = {
        username: document.getElementById("username").value,
        password: document.getElementById("password").value
    }

    let response = await fetch(URL + "login", {
        method: "POST",
        body: JSON.stringify(user),
        credentials: "include"
    });

    if (response.status === 200) {
        document.getElementsByClassName("formClass")[0].innerHTML = "";
        buttonRow.appendChild(reimbButton);
        buttonRow.appendChild(userButton);
    } else {
        let para = document.createElement("p");
        para.setAttribute("style", "color:red");
        para.innerText = "LOGIN FAILED";
        document.getElementsByClassName("formClass")[0].appendChild(para);
    }
}
async function getAllReimbs() {
    let response = await fetch(URL + "reimbs", { credentials: "include" });

    if (response.status === 200) {
        let data = await response.json();
        populateReimbsTable(data);
    } else {
        console.log("There are no reimbs to show");
    }
}

function populateReimbsTable(data) {
    let tbody = document.getElementById("reimbursementBody");

    tbody.innerHTML = "";

    for (let reimb of data) {
        let row = document.createElement("tr");

        for (let cell in reimb) {
            let td = document.createElement("td");
            if (cell != "home") {
                td.innerText = reimb[cell];
            } else if (reimb[cell]) {
                td.innerText = `${reimb[cell].name}: ${reimb[cell].streetNumber} ${reimb[cell].streetName} ${reimb[cell].city } ${reimb[cell].region}, ${reimb[cell].zip} ${reimb[cell].country}`
            }
            row.appendChild(td);
        }
        tbody.appendChild(row);
    }
}

async function getAllUsers() {
    let response = await fetch(URL + "ersUsers", { credentials: "include" });
    if (response.status === 200) {
        let data = await response.json();
        populateUsersTable(data);
    } else {
        console.log("Users not available.");
    }
}

function populateUsersTable(data) {
    let tbody = document.getElementById("ersUsersBody");

    tbody.innerHTML = "";

    for (let reimb of data) {
        let row = document.createElement("tr");
        for (let cell in reimb) {
            let td = document.createElement("td");
            td.innerText = reimb[cell];
            row.appendChild(td);
        }
        tbody.appendChild(row);
    }
}

function getNewReimb() {
    let newReimbId = document.getElementById("username").value;
    let newReimbAmount = document.getElementById("firstName").value;
    let newReimbSubmitted = document.getElementById("LastName").value;
    let newReimbResolved = document.getElementById("email").value;
    let newReimbDescr = document.getElementById("roleId").value;
    // let newReimbReceipt = document.getElementById().value;
    let newReimbAuthor = document.getElementById("reimbursementAuthor").value;
    let newReimbResolver = document.getElementById("reimbursementAuthor").value;
    let newReimbStatus = document.getElementById("reimbursementStatus").value;
    let newReimbType = document.getElementById("reimbursementType").value;


    let user = {
        reimbId: newReimbId,
        reimbamount: newReimbAmount,
        reimbSubmitted: newReimbSubmitted,
        reimbResolved: newReimbResolved,
        reimbDescr: newReimbDescr,
        reimbAuthor: newReimbAuthor,
        reimbResolver: newReimbResolver,
        reimbStatus: newReimbStatus,
        reimbType: newReimbType
    }

    return user;
}

async function addReimb() {
    let reimb = getnewReimb();

    let response = await fetch(URL + "reimbs", {
        method: 'POST',
        body: JSON.stringify(reimb),
        credentials: "include"
    });

    if (response.status === 201) {
        console.log("User created successfully.");
    } else {
        console.log("Something went wrong creating your user.")
    }

}