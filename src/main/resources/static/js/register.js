document.querySelector("#register-submit").addEventListener("click",(event) => {
    
    
    let fullName = document.querySelector("#fullname").value;
    let email = document.querySelector("#email").value;
    let password = document.querySelector("#password").value;

    (fullName !== "" && email !== "" && password !== "")? 
        event.preventDefault()
    :
        console.log("yes")
});