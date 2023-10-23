//IMPORTACIONES
import { getAllProducts } from "../service/product.js";

//INSTANCIAS
const contenedor0 = document.getElementById("contenedor0")
const contenedor1 = document.getElementById("contenedor1")
const contenedor2 = document.getElementById("contenedor2")
const contenedor3 = document.getElementById("contenedor3")

const fillProducts = async () => {
    const products = await getAllProducts()

    products.forEach(product => {
        const category = product.category
        let container;
        if (category == "men's clothing") {
            container = contenedor1;
        } else if (category == "jewelery") {
            container = contenedor2;
        } else if (category == "electronics") {
            container = contenedor3;
        } else if (category == "women's clothing") {
            container = contenedor0;
        }

        //crear elemento

        container.innerHTML += `
        <div class="col-12">
            <div class="m-3 row">
                <div class="col-5 d-flex justify-content-center align-items-center">
                    <img class="card-img-top" src="${product.image}" alt="" style="width: 250px;">
                </div>
                <div class=" card p-4 col d-flex justify-content-center align-items-center">
                    <div class="text-start">
                        <p>Id: ${product.id} </p>
                        <p>titulo: ${product.title}</p>
                        <p>descripción: ${product.description}</p>
                        <p>tiempo: ${product.price}</p>
                        <p>responsable: </p>
                        <p>estado: ${product.category}</p>
                    </div>
                    <div class="text-center">
                        <a href="" class="btn btn-outline-success mt-auto">
                            Ver
                        </a>
                    </div>
                </div>
            </div>
        </div>
        `
    });

}

fillProducts();