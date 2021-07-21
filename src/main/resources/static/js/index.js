

document.querySelector("#add-product").addEventListener("click", () => {
    document.querySelector(".popup").style.display = "flex";
});

document.querySelector("#close-popup").addEventListener("click", () => {
    document.querySelector(".popup").style.display = "none";
});

const updateProduct = (id) => {
    let productNameInputs = document.querySelectorAll(`.product-name-input`);
    document.querySelectorAll(`.product-name`).forEach((elem,index) => {
        elem.style.display="block";
        productNameInputs[index].style.display="none"
    });

    document.querySelector(`#product-name-${id}`).style.display="none";
    document.querySelector(`#product-name-input-${id}`).style.display="block";
}

const deleteProduct = (id) => {
    async function delProd(id){
        let product_obj = {
            product_id: id,
            product_name: "xd",
            price: 0,
            discount_price: 0
        }
        const response = await fetch('/product/delete',{
            method: "DELETE",
            headers: {
                "Content-type":"application/json"
            },
            body: JSON.stringify(product_obj)
        }).then(res => {

        });
    }

    delProd(id);
    document.querySelector(`#product-${id}`).remove();
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

