

document.querySelector("#add-product").addEventListener("click", () => {
    document.querySelector(".popup").style.display = "flex";
});

document.querySelector("#close-popup").addEventListener("click", () => {
    document.querySelector(".popup").style.display = "none";
});

const deleteProduct = (id) => {
    alert(id);
}

document.querySelector(".popup-body form").addEventListener("submit", (e) => {
    e.preventDefault();

    let product_name=document.querySelector("#product-name").value;
    let brand=document.querySelector("#brand").value;
    let price=document.querySelector("#price").value;
    let discount_price=document.querySelector("#discount_price").value;

    let product = {
        product_name,
        brand,
        price,
        discount_price
    };

    async function passData(product) {
        const response = await fetch("/product/save",
       {
           method: "POST",
           headers:{
               "Content-type":"application/json"
           },
           body: JSON.stringify(product)
       }).then(res => {
           console.log(res.text());
       });
    }

    passData(product);
});

