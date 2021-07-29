

document.querySelector("#add-product").addEventListener("click", () => {
    document.querySelector(".popup").style.display = "flex";
});

document.querySelector("#close-popup").addEventListener("click", () => {
    document.querySelector(".popup").style.display = "none";
});

const updateModal =(id) => {
    document.querySelector(`#popup-2-${id}`).style.display = "flex";
}

const closeModal =(id) => {
    document.querySelector(`#popup-2-${id}`).style.display = "none";
}

const updateProduct = (id) => {
    let product_name = document.querySelector(`#product-name-${id}`).value;
    let brand = document.querySelector(`#product-brand-${id}`).value;
    let price = document.querySelector(`#product-price-${id}`).value;
    let discount_price = document.querySelector(`#product-discount-price-${id}`).value;

    console.log(document.querySelector(`#product-brand-${id}`))
    async function updProd(id, product_name,brand,price,discount_price){
        let product_obj = {
            product_id: id,
            product_name,
            brand,
            price,
            discount_price
        }

        const response = await fetch('/product/update', {
            method: 'PUT',
            headers: {
                "Content-type":"application/json"
            },
            body: JSON.stringify(product_obj)
        }).then( res => {
            res.text();
        })
    }

    updProd(id,product_name,brand,price,discount_price);
    location.reload();
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

